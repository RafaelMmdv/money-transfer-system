package az.transfer.moneytransfersystem.service;

import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import az.transfer.moneytransfersystem.dao.repository.UserRepository;
import az.transfer.moneytransfersystem.dto.request.UserDetailsDto;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import az.transfer.moneytransfersystem.dto.response.UserSecurityResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserSecurityDetailsService<UsersEntity> implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = fetchUserByUsername(username);
        UserSecurityResponseDto userSecurityResponseDto = UserSecurityResponseDto
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();


        return UserDetailsDto
                .builder()
                .userSecurityResponseDto(userSecurityResponseDto)
                .authorities(grantedAuthorities(user))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
    }

    private Collection<? extends GrantedAuthority> grantedAuthorities(UserEntity user) {

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));

            role.getAuthorities().forEach(authority -> {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
            });
        });
        return simpleGrantedAuthorities;
    }

    private UserEntity fetchUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow();

    }
}

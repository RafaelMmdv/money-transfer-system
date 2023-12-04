package az.transfer.moneytransfersystem.service;

import az.transfer.moneytransfersystem.dao.entity.UserEntity;
import az.transfer.moneytransfersystem.dao.repository.RoleRepository;
import az.transfer.moneytransfersystem.dao.repository.UserRepository;
import az.transfer.moneytransfersystem.dto.request.UserDetailsDto;
import az.transfer.moneytransfersystem.dto.response.UserResponseDto;
import az.transfer.moneytransfersystem.dto.response.UserSecurityResponseDto;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.UserDatabase;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserSecurityDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void createAdminForManagement(){
        if (userRepository.findByUsername("RafaelM").isEmpty()){
            userRepository.save(UserEntity
                    .builder()
                    .name("Rafael")
                    .username("RafaelM")
                    .surname("Mammadov")
                    .password(passwordEncoder.encode("1234"))
                    .build()
            )               ;
        }
    }

    @Transactional
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

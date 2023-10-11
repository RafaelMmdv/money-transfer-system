package az.transfer.moneytransfersystem.dto.request;

import az.transfer.moneytransfersystem.dto.response.UserSecurityResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Builder
@RequiredArgsConstructor

public class UserDetailsDto implements UserDetails {

    private final UserSecurityResponseDto userSecurityResponseDto;

    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean isEnabled;
    private final boolean isCredentialsNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isAccountNonExpired;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {

        return userSecurityResponseDto.getPassword();

    }

    @Override
    public String getUsername() {

        return userSecurityResponseDto.getUsername();
    }

}

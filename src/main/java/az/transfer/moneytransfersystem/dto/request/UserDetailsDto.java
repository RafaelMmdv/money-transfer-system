package az.transfer.moneytransfersystem.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@RequiredArgsConstructor

public class UserDetailsDto implements UserDetails {

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
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

}

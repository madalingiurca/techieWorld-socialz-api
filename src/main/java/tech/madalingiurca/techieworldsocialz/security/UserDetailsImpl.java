package tech.madalingiurca.techieworldsocialz.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.madalingiurca.techieworldsocialz.database.entity.User;

import java.util.Collection;
import java.util.Collections;

import static tech.madalingiurca.techieworldsocialz.security.Role.ROLE_USER;

@Getter
@Builder
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String alias;

    private String username;

    private String password;

    public UserDetailsImpl(User user) {
        this.alias = user.getAlias();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(ROLE_USER.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.memeov1.memeov1.auth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.memeov1.memeov1.entities.Login;

public class SecurityUser implements UserDetails {

    public Login login;

    public SecurityUser(Login login) {
        this.login = login;
    }

    @Override
    public String getUsername() {
        return login.getUsername();
    }

    @Override
    public String getPassword() {
        return login.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
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

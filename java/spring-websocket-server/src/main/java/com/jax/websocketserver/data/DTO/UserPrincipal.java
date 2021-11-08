package com.jax.websocketserver.data.DTO;

import com.jax.websocketserver.data.response.UserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String id;

    private Collection<? extends GrantedAuthority> authorities;
    private UserInfo userInfo;

    public UserPrincipal() {
        super();
    }

    public UserPrincipal(UserInfo userInfo, Collection< ? extends GrantedAuthority> authorities) {

    }

    public static UserPrincipal create(UserInfo userInfo) {
                List<GrantedAuthority> authorities = userInfo.getScopes().stream().map((scope) -> new SimpleGrantedAuthority(String.valueOf(scope))).collect(Collectors.toList());

//        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USERS"));
        return new UserPrincipal(userInfo, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}

package org.jjinppang.jjinppang.security.oauth;

import lombok.Data;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.type.Provider;
import org.jjinppang.jjinppang.domain.user.type.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class CustomOAuth2User implements OAuth2User {

    private int userId;
    private Provider userProvider;
    private String userProviderId;
    private String userName;
    private Role role;

    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public CustomOAuth2User(int userId, Provider userProvider, String userProviderId, String userName, Role role, Collection<? extends GrantedAuthority> authorities,Map<String, Object> attributes) {
        this.userId = userId;
        this.userProvider = userProvider;
        this.userProviderId = userProviderId;
        this.userName = userName;
        this.role = role;
        this.authorities = authorities;
        this.attributes = attributes;
    }

    public static CustomOAuth2User create(User user, Map<String, Object> attributes) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority(String.valueOf(user.getUserRole())));
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(
                user.getUserId(),
                user.getUserProvider(),
                user.getUserProviderId(),
                user.getUserNickname(),
                user.getUserRole(),
                authorities,
                attributes);

        return customOAuth2User;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return String.valueOf(userId);
    }
}
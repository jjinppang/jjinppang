package org.jjinppang.jjinppang.security.oauth;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.Collection;


@Getter
@Setter
public class LoginUserDetails extends User {

    private org.jjinppang.jjinppang.domain.user.User user;

    public LoginUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


}

package org.jjinppang.jjinppang.security.service;

import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.jjinppang.jjinppang.security.oauth.LoginUserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.jjinppang.jjinppang.common.NotFoundException.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User findUser = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(findUser.getUserRole())));

        LoginUserDetails loginUserDetails = new LoginUserDetails(String.valueOf(findUser.getUserId()), "", authorities);
        loginUserDetails.setUser(findUser);

        return loginUserDetails;
    }
}

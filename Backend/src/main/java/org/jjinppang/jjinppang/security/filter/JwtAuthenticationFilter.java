package org.jjinppang.jjinppang.security.filter;


import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.security.oauth.LoginUserDetails;
import org.jjinppang.jjinppang.security.service.UserDetailService;
import org.jjinppang.jjinppang.security.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailService userDetailService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String jwt = extractToken((HttpServletRequest) request);

        if (StringUtils.hasText(jwt) && jwtUtil.isValidToken(jwt)) {
            UserDetails userDetails = userDetailService.loadUserByUsername(jwtUtil.getSubject(jwt));
            LoginUserDetails loginUserDetails = (LoginUserDetails) userDetails;

            Authentication authentication = new UsernamePasswordAuthenticationToken(loginUserDetails.getUser(), null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

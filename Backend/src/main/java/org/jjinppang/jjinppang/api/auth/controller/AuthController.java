package org.jjinppang.jjinppang.api.auth.controller;

import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.auth.response.TokenResponse;
import org.jjinppang.jjinppang.api.auth.service.AuthService;
import org.jjinppang.jjinppang.config.LoginUser;
import org.jjinppang.jjinppang.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //토큰 재발급
    @PostMapping("/refresh")
    public ResponseEntity regenerateAccessToken(@LoginUser User user, @RequestHeader("Authorization") String refreshToken){
        TokenResponse token = authService.regenerateAccessToken(user.getUserId(), refreshToken.substring(7));

        return ResponseEntity.status(HttpStatus.OK)
                .header("accessToken", token.getAccessToken())
                .header("refreshToken", token.getRefreshToken())
                .build();

    }
}

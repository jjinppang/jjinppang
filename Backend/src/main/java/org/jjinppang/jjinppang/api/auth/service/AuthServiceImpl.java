package org.jjinppang.jjinppang.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.auth.response.TokenResponse;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.common.NotMatchException;
import org.jjinppang.jjinppang.domain.auth.Auth;
import org.jjinppang.jjinppang.domain.auth.repository.AuthRepository;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.jjinppang.jjinppang.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.jjinppang.jjinppang.common.NotFoundException.USER_NOT_FOUND;
import static org.jjinppang.jjinppang.common.NotFoundException.AUTH_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    @Value("${token.access_token.expiration_time}")
    private String accessTokenExpirationTime;
    @Value("${token.refresh_token.expiration_time}")
    private String refreshTokenExpirationTime;
    @Value("${token.refresh_token.expiration_date}")
    private Long refreshTokenExpirationDate;

    // 토큰 발급
    @Override
    public TokenResponse generateToken(int userId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));

        String accessToken = jwtUtil.createToken(findUser.getUserId(), String.valueOf(findUser.getUserRole()), accessTokenExpirationTime);
        String refreshToken = jwtUtil.createToken(findUser.getUserId(), String.valueOf(findUser.getUserRole()), refreshTokenExpirationTime);

        Auth auth = Auth.createAuth(findUser.getUserId(), refreshToken, refreshTokenExpirationDate);
        authRepository.save(auth);
        return new TokenResponse(accessToken, refreshToken);
    }


    // 토큰 재발급
    @Override
    public TokenResponse regenerateAccessToken(int userId, String refreshToken) {

        Auth findAuth = authRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(AUTH_NOT_FOUND));

        if (!refreshToken.equals(findAuth.getRefreshToken())) {
            throw new NotMatchException("Refresh Token이 일치하지 않습니다.");
        }

        String accessToken = jwtUtil.createToken(refreshToken, accessTokenExpirationTime);

        //남아있는 시간이 7일 미만이라면
        if (findAuth.getExpiration() < 7) {
            refreshToken = jwtUtil.createToken(refreshToken, refreshTokenExpirationTime);

            Auth auth = Auth.createAuth(userId, refreshToken, refreshTokenExpirationDate);
            authRepository.save(auth);
        }
        return new TokenResponse(accessToken, refreshToken);
    }
}

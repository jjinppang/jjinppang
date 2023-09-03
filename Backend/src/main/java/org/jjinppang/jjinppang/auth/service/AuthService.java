package org.jjinppang.jjinppang.auth.service;

import org.jjinppang.jjinppang.auth.response.TokenResponse;

public interface AuthService {

    TokenResponse generateToken(int userId);

    TokenResponse regenerateAccessToken(int userId, String refreshToken);
}

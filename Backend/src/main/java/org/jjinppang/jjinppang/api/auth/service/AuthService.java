package org.jjinppang.jjinppang.api.auth.service;

import org.jjinppang.jjinppang.api.auth.response.TokenResponse;

public interface AuthService {

    TokenResponse generateToken(int userId);

    TokenResponse regenerateAccessToken(int userId, String refreshToken);
}

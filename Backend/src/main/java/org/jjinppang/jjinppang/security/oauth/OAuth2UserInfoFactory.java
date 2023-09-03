package org.jjinppang.jjinppang.security.oauth;

import org.jjinppang.jjinppang.common.OAuthProviderNotExistException;
import org.jjinppang.jjinppang.domain.user.type.Provider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equals(Provider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equals(Provider.kakao.toString())) {
            return new KakaoOAuth2UserInfo(attributes);
        }  else {
            throw new OAuthProviderNotExistException(registrationId);
        }
    }
}

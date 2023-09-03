package org.jjinppang.jjinppang.security.oauth;

import org.jjinppang.jjinppang.domain.user.type.Provider;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getUserNickname() {
        return (String) attributes.get("name");
    }


    @Override
    public Provider getUserProvider() {
        return Provider.google;
    }

    @Override
    public String getUserName() {
        return getUserProvider() + "_" + getUserProviderId();
    }

    @Override
    public String getUserProviderId() {
        return (String) attributes.get("sub");
    }
}
package org.jjinppang.jjinppang.api.user.service;

import org.jjinppang.jjinppang.api.user.request.UpdateUserProfileRequest;
import org.jjinppang.jjinppang.api.user.response.UserProfileResponse;
import org.jjinppang.jjinppang.domain.user.User;

public interface UserService {

    UserProfileResponse findUser(User user);

    void updateUserProfile(User user, UpdateUserProfileRequest request);

    void updateUserProfileImage(User user);

}

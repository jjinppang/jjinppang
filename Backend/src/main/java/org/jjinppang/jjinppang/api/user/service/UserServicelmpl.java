package org.jjinppang.jjinppang.api.user.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jjinppang.jjinppang.api.user.request.UpdateUserProfileRequest;
import org.jjinppang.jjinppang.api.user.response.UserProfileResponse;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServicelmpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserProfileResponse findUser(User user) {
        User findUserProfile = userRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND));
        return UserProfileResponse.from(findUserProfile);
    }

    @Transactional
    @Override
    public void updateUserProfile(User user, UpdateUserProfileRequest request) {
        user.updateUserProfile(request.getUserNickname());
        userRepository.save(user);
        
    }

    @Override
    public void updateUserProfileImage(User user) {

    }

}

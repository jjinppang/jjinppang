package org.jjinppang.jjinppang.api.user.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.user.request.UpdateUserProfileRequest;
import org.jjinppang.jjinppang.api.user.service.UserService;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.jjinppang.jjinppang.config.LoginUser;
import org.jjinppang.jjinppang.domain.user.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 프로필 조회", description = "유저 아이디로 프로필 조회")
    @GetMapping
    public ApiResponse<Object> getUserProfile(@LoginUser User user) {
        return ApiResponse.createSuccess(
                userService.findUser(user)
        );
    }

    @Operation(summary = "유저 프로필 수정", description = "유저 이미지 제외한 정보 수정")
    @PutMapping(value = "/update")
    public ApiResponse<Object> updateUserProfile(@LoginUser User user, @RequestBody UpdateUserProfileRequest request) {
        userService.updateUserProfile(user, request);
        return ApiResponse.createSuccess(user);
    }

    @Operation(summary = "유저 이미지 수정", description = "유저 이미지 수정")
    @PutMapping(value = "/update/image")
    public ApiResponse<Object> updateUserProfileImage(@LoginUser User user, @RequestPart("file") MultipartFile multipartFile) throws Exception {
        userService.updateUserProfileImage(user);
        return ApiResponse.createSuccess(user);
    }


}
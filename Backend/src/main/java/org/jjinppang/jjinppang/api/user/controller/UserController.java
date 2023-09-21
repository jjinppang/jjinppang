package org.jjinppang.jjinppang.api.user.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.user.request.CreateUserInterestRegionRequest;
import org.jjinppang.jjinppang.api.user.request.UpdateUserProfileRequest;
import org.jjinppang.jjinppang.api.user.service.UserService;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.jjinppang.jjinppang.config.LoginUser;
import org.jjinppang.jjinppang.domain.user.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 프로필 조회", description = "유저 아이디로 프로필 조회")
    @GetMapping(value = "/profile")
    public ApiResponse<Object> getUserProfile(@LoginUser User user) {
        return ApiResponse.createSuccess(
                userService.findUser(user)
        );
    }

    @Operation(summary = "유저 프로필 수정", description = "유저 이미지 제외한 정보 수정")
    @PutMapping(value = "/profile")
    public ApiResponse<Object> updateUserProfile(@LoginUser User user, @RequestBody UpdateUserProfileRequest request) {
        userService.updateUserProfile(user, request);
        return ApiResponse.createSuccess("");
    }

    @Operation(summary = "유저 이미지 수정", description = "유저 이미지 수정")
    @PutMapping(value = "/profile/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<Object> updateUserProfileImage(@LoginUser User user, @RequestPart MultipartFile multipartFile){

        System.out.println(multipartFile);
        userService.updateUserProfileImage(user, multipartFile);
        return ApiResponse.createSuccess("");
    }

    @Operation(summary = "유저 관심 지역 조회", description = "지역에 기반한 유저의 모든 관심 지역을 리스트로 조회")
    @GetMapping(value = "/interest-region")
    public ApiResponse<Object> getUserInterestRegion(@LoginUser User user){
        return ApiResponse.createSuccess(
                userService.findUserInterestRegion(user)
        );
    }

    @Operation(summary = "유저 관심 지역 저장", description = "지역에 기반한 유저 관심 지역 저장")
    @PostMapping(value = "/interest-region")
    public ApiResponse<Object> createUserInterestRegion(@LoginUser User user, @RequestBody CreateUserInterestRegionRequest request){
        userService.createUserInterestRegion(user, request);
        return ApiResponse.createSuccess("");
    }

    @Operation(summary = "유저 관심 지역 삭제", description = "유저 관심 지역 삭제")
    @DeleteMapping(value = "/interest-region/{interest-region-id}")
    public ApiResponse<Object> deleteUserInterestRegion(@LoginUser User user, @PathVariable("interest-region-id") Integer userInterestRegionId){
        userService.deleteUserInterestRegion(user, userInterestRegionId);
        return ApiResponse.createSuccess("");
    }

}
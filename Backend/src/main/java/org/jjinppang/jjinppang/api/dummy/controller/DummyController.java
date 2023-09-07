package org.jjinppang.jjinppang.api.dummy.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.jjinppang.jjinppang.config.LoginUser;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Dummy", description = "아직 구현되지 않은 더미 API 문서입니다.")
public class DummyController {

    private final UserRepository userRepository;

    public Object getDummy(String filePath) {
        try {
            String data = "";
            ClassPathResource cpr = new ClassPathResource(filePath);
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(data);
            return object;

        } catch (Exception exception) {
            throw new NotFoundException(NotFoundException.FILE_NOT_FOUND);
        }
    }

//    @GetMapping("/dummy")
//    public ApiResponse<String> dummy() {
//        return ApiResponse.createSuccess("dummy success");
//    }

    @GetMapping("/user/profile")
    @Operation(summary = "유저 프로필", description = "사용자 기본 정보를 조회합니다.")
    public ApiResponse<Object> userProfile(@LoginUser User user) throws Exception {
        try {
            Object object = this.getDummy("/profile.json");
            return ApiResponse.createSuccess(object);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/user/likePlace")
    @Operation(summary = "유저 관심지역", description = "사용자가 저장한 관심지역 목록을 불러옵니다.")
    public ApiResponse<Object> userLikeRegion(@LoginUser User user) throws Exception {
        try {
            Object object = this.getDummy("/likeRegion.json");
            object = (JSONObject) object;
            return ApiResponse.createSuccess(((JSONObject) object).get("results"));
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @GetMapping("/search")
    @Operation(summary = "키워드 검색", description = "키워드를 포함하는 지역명과 건물명에 해당하는 결과를 불러옵니다.")
    public ApiResponse<Object> searchRegion(@RequestParam("keyword") String keyword) throws Exception {
        try {
            Object object = this.getDummy("/searchRegion.json");
            object = (JSONObject) object;
            return ApiResponse.createSuccess(((JSONObject) object).get("results"));
        } catch (Exception e) {
            throw new Exception();
        }
    }
}

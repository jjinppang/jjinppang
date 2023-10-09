package org.jjinppang.jjinppang.api.dummy.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.common.response.ApiResponse;
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
//    private final OpenApiRunner openApiRunner;
//    private final OpenApiConnection openApiConnection = new OpenApiConnection("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcRHRent", "brx3K3JOj/eXfLq/kFcyZJCas2gBPqCBvKTqbf8J3KtTif4dIFljHQED9u9ZsoVquE+U7F0Zza1Sn/ISwrI1Jg==", "11110", "201512");

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

    @GetMapping("/contract/all")
    @Operation(summary = "전체 계약 정보", description = "전체 계약 정보를 불러옵니다.")
    public ApiResponse<Object> contractAll(@RequestParam("deposit") String deposit) throws Exception {
        try {
            JSONObject object = (JSONObject) (deposit.equals("monthly") ? this.getDummy("/dong_info_monthly.json") : this.getDummy("/dong_info_yearly.json"));
            System.out.println(object.get("results"));
            return ApiResponse.createSuccess(object);
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

//    @GetMapping("/test/contract")
//    public ResponseEntity<?> testContract() {
//        return openApiConnection.dummyfetch();
//    }

//    @GetMapping("/test/runner")
//    public ResponseEntity<?> testRunner() {
//
//        try {
//            ClassPathResource cpr = new ClassPathResource("/sigungu_code.csv");
//
//            String[] dates = {"202201", "202202", "202203", "202204", "202205", "202206", "202207", "202208", "202209", "202210", "202211", "202212", "202301", "202302", "202303", "202304", "202305", "202306", "202307", "202308", "202309"};
//            String[] regionCodes = new String[265];
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(cpr.getInputStream(), "UTF-8"));
//
//            String line = "";
//
//            for (int i = 0; (line = br.readLine()) != null; i++) {
//                regionCodes[i] = line;
//            }
//            System.out.println(regionCodes[240]);
//
//            for (String date : dates) {
//                for (String regionCode : regionCodes) {
//                    System.out.println("code: " + regionCode + " date: " + date);
//                    openApiRunner.run(regionCode, date);
//                }
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return ResponseEntity.ok("success");
//    }
}

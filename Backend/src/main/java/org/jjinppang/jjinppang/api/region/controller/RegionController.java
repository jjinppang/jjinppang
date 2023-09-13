package org.jjinppang.jjinppang.api.region.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.region.request.MapRangeRequest;
import org.jjinppang.jjinppang.api.region.response.MarkerListResponse;
import org.jjinppang.jjinppang.api.region.service.RegionService;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/region")
@RestController
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/markers")
    @Operation(summary = "행정구역 리스트 조회 API", description =
            "지도 bounds 좌표와 행정구역 단위 level 을 보내 조회합니다<br>"
            + "level  :  0 = 광역시/도  |  1 = 시/군/구  |  2 = 읍/면/동<br>"
            + "rentType : monthly = 월세 | yearly = 전세"
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200", description = "Successful Operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MarkerListResponse.class)))),
            }
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(

    )
    public ApiResponse<Object> findMarkers(MapRangeRequest mapRangeRequest) {
        return ApiResponse.createSuccess(
                regionService.findByLatLngRangeAndRegionLevel(mapRangeRequest)
        );
    }

}

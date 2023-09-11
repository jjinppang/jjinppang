package org.jjinppang.jjinppang.api.region.controller;

import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.api.region.request.MapRangeRequest;
import org.jjinppang.jjinppang.api.region.service.RegionService;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/region")
@RestController
@RequiredArgsConstructor
public class controller {

    private final RegionService regionService;

    @GetMapping("/markers")
    public ApiResponse<Object> findMarkers(MapRangeRequest mapRangeRequest) {
        return ApiResponse.createSuccess(
                regionService.findByLatLngRangeAndRegionLevel(mapRangeRequest)
        );
    }

}

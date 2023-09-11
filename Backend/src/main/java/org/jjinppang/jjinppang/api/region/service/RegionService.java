package org.jjinppang.jjinppang.api.region.service;

import org.jjinppang.jjinppang.api.region.request.MapRangeRequest;
import org.jjinppang.jjinppang.api.region.response.MarkerListResponse;

import java.util.List;

public interface RegionService {

    // 시도 단위 마커 조회
    List<MarkerListResponse> findByLatLngRangeAndRegionLevel(MapRangeRequest mapRangeRequest);
}

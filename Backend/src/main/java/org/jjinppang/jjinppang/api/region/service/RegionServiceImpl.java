package org.jjinppang.jjinppang.api.region.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jjinppang.jjinppang.api.region.request.MapRangeRequest;
import org.jjinppang.jjinppang.api.region.response.MarkerListResponse;
import org.jjinppang.jjinppang.domain.region.repository.RegionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public List<MarkerListResponse> findByLatLngRangeAndRegionLevel(MapRangeRequest mapRangeRequest) {
        double bottomLat = mapRangeRequest.getBottomLat();
        double topLat = mapRangeRequest.getTopLat();
        double bottomLng = mapRangeRequest.getBottomLng();
        double topLng = mapRangeRequest.getTopLng();
        int level = mapRangeRequest.getLevel();

        PageRequest pageable = PageRequest.of(0, 100);

        return regionRepository.findByLatLngRangeAndRegionLevel(bottomLat, topLat, bottomLng, topLng, level, pageable).stream().map(MarkerListResponse::from).collect(Collectors.toList());
    }
}

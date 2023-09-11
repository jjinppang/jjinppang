package org.jjinppang.jjinppang.domain.region.repository;

import org.jjinppang.jjinppang.domain.region.Region;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RegionRepository extends JpaRepository<Region, String> {
    @Query("select r from Region r where r.centerLat > ?1 and r.centerLat < ?2 and r.centerLng > ?3 and r.centerLng < ?4 and r.regionLevel = ?5")
    List<Region> findByLatLngRangeAndRegionLevel(double bottomLat, double topLat, double bottomLng, double topLng, int regionLevel, Pageable pageable);

}
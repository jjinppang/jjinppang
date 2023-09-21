package org.jjinppang.jjinppang.domain.user.repository;

import org.jjinppang.jjinppang.domain.region.Region;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.UserInterestRegion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInterestRegionRepository extends JpaRepository<UserInterestRegion, Integer> {

    List<UserInterestRegion> findUserInterestRegionByUser(User user);

    Optional<UserInterestRegion> findByUserandRegion(User user, Region region);



}
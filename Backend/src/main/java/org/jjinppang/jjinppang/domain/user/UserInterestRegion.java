package org.jjinppang.jjinppang.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jjinppang.jjinppang.domain.region.Region;

import javax.persistence.*;

// Region에 기반한 사용자 관심 지역
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class UserInterestRegion {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userInterestRegionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;



    public static UserInterestRegion createUserInterestRegion(User user, Region region) {
        UserInterestRegion userInterestRegion = new UserInterestRegion();
        userInterestRegion.user = user;
        userInterestRegion.region = region;

        return userInterestRegion;
    }
}

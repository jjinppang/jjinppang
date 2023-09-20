package org.jjinppang.jjinppang.api.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jjinppang.jjinppang.domain.region.Region;
import org.jjinppang.jjinppang.domain.user.UserInterestRegion;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInterestRegionResponse {

    double centerLng;
    double centerLat;

    String emdCode;
    String emdName;

    Integer depositPrice;
    Integer monthlyDepositPrice;
    Integer monthlyRentPrice;


    public static UserInterestRegionResponse from(UserInterestRegion userInterestRegion){

        Region region = userInterestRegion.getRegion();

        return new UserInterestRegionResponse(
                region.getCenterLng(),
                region.getCenterLat(),
                region.getEmdCode(),
                region.getEmdName(),
                1000,
                1000,
                100

        );
    }

}

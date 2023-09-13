package org.jjinppang.jjinppang.api.region.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jjinppang.jjinppang.domain.region.Region;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkerListResponse {
    String sidoCode;
    String sidoName;
    String sigunguCode;
    String sigunguName;
    String emdCode;
    String emdName;
    double centerLat;
    double centerLng;

    int depositPrice;
    int monthlyPrice;

    public static MarkerListResponse from(Region region) {
        return new MarkerListResponse(
                region.getSidoCode(),
                region.getSidoName(),
                region.getSigunguCode(),
                region.getSigunguName(),
                region.getEmdCode(),
                region.getEmdName(),
                region.getCenterLat(),
                region.getCenterLng(),
                1000,100
        );
    }


}

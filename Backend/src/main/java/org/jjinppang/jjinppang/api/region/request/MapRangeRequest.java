package org.jjinppang.jjinppang.api.region.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapRangeRequest {
    double topLat;
    double bottomLat;
    double topLng;
    double bottomLng;
    int level;
    String rentType;
}

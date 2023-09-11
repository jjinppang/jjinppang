package org.jjinppang.jjinppang.domain.region;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


//create table region
//        (
//        region_id        varchar(30)      null,
//        center_point     text             null,
//        center_lng       double precision null,
//        center_lat       double precision null,
//        region_full_name text             null,
//        region_level     integer          null,
//        sido_code        varchar(30)      null,
//        sido_name        text             null,
//        sigungu_code     varchar(30)      null,
//        sigungu_name     text             null,
//        emd_code         varchar(30)      null,
//        emd_name         text             null,
//        li_name          text             null,
//        sigungu_count    integer          null,
//        emd_count        integer          null,
//        li_count         integer          null,
//        sigungu_list     text             null,
//        emd_list         text             null,
//        li_list          text             null
//        );

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Region {
    @Id
    @Column(length = 30, nullable = false)
    private String regionId;

    private String centerPoint;
    private double centerLng;
    private double centerLat;

    private String regionFullName;
    private int regionLevel;
    private String sidoCode;
    private String sidoName;
    private String sigunguCode;
    private String sigunguName;
    private String emdCode;
    private String emdName;
    private String liName;
    private int sigunguCount;
    private int emdCount;
    private int liCount;
    private String sigunguList;
    private String emdList;
    private String liList;
}

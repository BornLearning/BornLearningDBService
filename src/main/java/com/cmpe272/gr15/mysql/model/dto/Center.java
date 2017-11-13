package com.cmpe272.gr15.mysql.model.dto;

import lombok.Data;

@Data
public class Center {

    private Integer centerId;

    private String centerName;

    private String centerAddress;

    private Integer pincode;

    private String type;

    private String chapter;

    private String city;

    private String district;

    private String sevika;

    private String sevikaPhone;

    private Integer facilitatorId;

    private String geoLocation;
}

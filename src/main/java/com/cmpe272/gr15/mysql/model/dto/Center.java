package com.cmpe272.gr15.mysql.model.dto;

import lombok.Data; // auto-generates the getters, setters of this class.
import org.springframework.stereotype.Component;

@Component
@Data
public class Center extends BaseDTO {

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

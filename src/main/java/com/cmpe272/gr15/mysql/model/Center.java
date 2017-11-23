package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Centers")
@Data
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "facilitatorID")
    private Integer facilitatorId;

    @Column(name = "geolocation")
    private String geoLocation;

}

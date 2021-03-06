package com.cmpe272.gr15.mysql.model;

import com.cmpe272.gr15.mysql.model.dto.BaseDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Indicators")
@Data
public class Indicator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer indicatorID;

    private String indicatorLabel;

    private String category;

    private String subCategory;

    private String ageGroup;

}

package com.cmpe272.gr15.mysql.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Indicator extends BaseDTO {

    private Integer indicatorID;

    private String indicatorLabel;

    private String category;

    private String subCategory;

    private String ageGroup;
}

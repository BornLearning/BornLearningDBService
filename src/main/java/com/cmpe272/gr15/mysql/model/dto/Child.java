package com.cmpe272.gr15.mysql.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Child extends BaseDTO {

    private Integer childID;

    private String childFName;

    private String childLName;

    private String childDOB;

    private String gender;

    private String guardianName;

    private String guardianPhone;

    private Integer centerID;

    private String imageID;

    private String active;

    private int age;

}

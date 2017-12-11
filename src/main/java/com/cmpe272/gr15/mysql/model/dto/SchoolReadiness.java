package com.cmpe272.gr15.mysql.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Data
public class SchoolReadiness extends BaseDTO {

    private Integer indicatorID;

    private Integer childID;

    private Integer response;

    private Date assessmentDate;
}

package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "SchoolReadiness")
@Data
public class SchoolReadiness {

    @Id
    private Integer indicatorID;

    private Integer childId;

    private Integer response;

    private Date assessmentDate;

}

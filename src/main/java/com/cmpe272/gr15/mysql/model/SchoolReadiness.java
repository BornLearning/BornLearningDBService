package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "SchoolReadiness")
@Data
public class SchoolReadiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolResRow;

    private Integer indicatorID;

    private Integer childID;

    private Integer response;

    @Temporal(TemporalType.DATE)
    private Date assessmentDate;

}

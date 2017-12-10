package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name= "Community")
@Data
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer communityResRow;

    private Integer indicatorID;

    private Integer centerId;

    private Integer response;

    @Temporal(TemporalType.DATE)
    private Date assessmentDate;
}

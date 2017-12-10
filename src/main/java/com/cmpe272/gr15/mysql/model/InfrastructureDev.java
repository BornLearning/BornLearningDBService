package com.cmpe272.gr15.mysql.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "InfrastructureDev")
@Data
public class InfrastructureDev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infraResRow;

    private Integer indicatorID;

    private Integer centerId;

    private Integer response;

    @Temporal(TemporalType.DATE)
    private Date assessmentDate;
}

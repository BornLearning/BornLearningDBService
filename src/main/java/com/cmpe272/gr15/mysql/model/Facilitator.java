package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Facilitators")
@Data
public class Facilitator {

    @Id
    private Integer facilitatorID;

    private String name;

    private String phone;

}
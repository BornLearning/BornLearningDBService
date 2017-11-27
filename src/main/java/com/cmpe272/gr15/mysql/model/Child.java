package com.cmpe272.gr15.mysql.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Children")
@Data
public class Child {
    public Integer getChildID() {
        return childID;
    }

    public void setChildID(Integer childID) {
        this.childID = childID;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer childID;

    public String getChildFName() {
        return childFName;
    }

    public void setChildFName(String childFName) {
        this.childFName = childFName;
    }

    private String childFName;

    public String getChildLName() {
        return childLName;
    }

    public void setChildLName(String childLName) {
        this.childLName = childLName;
    }

    private String childLName;

    public Integer getChildDOB() {
        return childDOB;
    }

    public void setChildDOB(Integer childDOB) {
        this.childDOB = childDOB;
    }

    private Integer childDOB;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    private String guardianName;

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    private String guardianPhone;

    public Integer getCenterID() {
        return centerID;
    }

    public void setCenterID(Integer centerID) {
        this.centerID = centerID;
    }

    private Integer centerID;

    private String imageID;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String active;
}

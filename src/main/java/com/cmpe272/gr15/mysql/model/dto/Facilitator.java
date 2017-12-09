package com.cmpe272.gr15.mysql.model.dto;

import com.cmpe272.gr15.mysql.model.dto.BaseDTO;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.Id;


@Component
@Data
public class Facilitator extends BaseDTO {

    public Integer getFacilitatorID() {
        return facilitatorID;
    }

    public void setFacilitatorID(Integer facilitatorID) {
        this.facilitatorID = facilitatorID;
    }

    private Integer facilitatorID;

    private String name;

    private String phone;

}
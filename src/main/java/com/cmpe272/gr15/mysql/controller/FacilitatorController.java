package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.model.dto.Facilitator;
import com.cmpe272.gr15.mysql.service.FacilitatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/facilitators")
public class FacilitatorController extends BornLearningController<Facilitator, FacilitatorService> {

    @Autowired
    public FacilitatorController(FacilitatorService facilitatorService) {
        super(facilitatorService);
    }

    /**
     * Get Center by Facilitator ID.
     * @param facilitatorID
     * @return
     */
    @RequestMapping(path = "/{facilitatorID}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Facilitator> getByFacilitatorId(@PathVariable Integer facilitatorID) {
        Facilitator facilitator = databaseService.getById(facilitatorID);
        if (facilitator == null) {
            throw new DataNotFoundException("Facilitator with ID: " + facilitatorID + " not found.");
        }
        return new ResponseEntity<>(facilitator, HttpStatus.OK);
    }
}
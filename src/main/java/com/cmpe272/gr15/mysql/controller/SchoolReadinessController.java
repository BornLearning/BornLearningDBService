package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.InsertingDataException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.dto.SchoolReadiness;
import com.cmpe272.gr15.mysql.service.SchoolReadinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class SchoolReadinessController extends BornLearningController<SchoolReadiness, SchoolReadinessService>{

    @Autowired
    public SchoolReadinessController(SchoolReadinessService schoolReadinessService){
        super(schoolReadinessService);
    }

    @RequestMapping(path = "/schoolReadiness", method = POST)
    public ResponseEntity<Void> addInfrastructureDevResponse(@RequestBody List<SchoolReadiness> schoolReadiness) {
        System.out.println(schoolReadiness);
        if(schoolReadiness.size()<=0){
            throw new InvalidDataException("Cannot save empty responses.");
        } else{
            for (SchoolReadiness schoolRes: schoolReadiness) {
                if (schoolRes.getIndicatorID() == null) {
                    throw new InvalidDataException("Indicator id cannot be blank.");
                }
                else if (schoolRes.getChildID() == null) {
                    throw new InvalidDataException("Child id cannot be blank.");
                }
                else if (schoolRes.getResponse() ==  null) {
                    throw new InvalidDataException("Response cannot be blank.");
                }
                else if (schoolRes.getAssessmentDate() ==  null) {
                    throw new InvalidDataException("Assessment Date cannot be blank.");
                }
            }
            try {
                databaseService.save(schoolReadiness);
            }
            catch(Exception e) {
                System.out.println("exception occured"+ e);
                throw new InsertingDataException("Error occurred while saving the response");
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

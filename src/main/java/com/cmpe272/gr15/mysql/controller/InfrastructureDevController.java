package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.exceptions.InsertingDataException;
import com.cmpe272.gr15.mysql.model.dto.InfrastructureDev;
import com.cmpe272.gr15.mysql.service.InfrastructureDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
//@RequestMapping("/")
public class InfrastructureDevController extends BornLearningController<InfrastructureDev, InfrastructureDevService>{

    @Autowired
    public InfrastructureDevController(InfrastructureDevService infrastructureDevService) {
        super(infrastructureDevService);
    }

    @RequestMapping(path = "/infrastructureDev", method = POST)
    public ResponseEntity<Void> addInfrastructureDevResponse(@RequestBody List<InfrastructureDev> infrastructureDev) {
        System.out.println(infrastructureDev);
        if(infrastructureDev.size()<=0){
            throw new InvalidDataException("Cannot save empty responses.");
        } else{
            for (InfrastructureDev infra: infrastructureDev) {
                if (infra.getIndicatorID() == null) {
                    throw new InvalidDataException("Indicator id cannot be blank.");
                }
                else if (infra.getCenterId() == null) {
                    throw new InvalidDataException("Center id cannot be blank.");
                }
                else if (infra.getResponse() ==  null) {
                    throw new InvalidDataException("Response cannot be blank.");
                }
                else if (infra.getAssessmentDate() ==  null) {
                    throw new InvalidDataException("Assessment Date cannot be blank.");
                }
            }
            try {
                databaseService.save(infrastructureDev);
            }
            catch(Exception e) {
                System.out.println("exception occured"+ e);
                throw new InsertingDataException("Error occurred while saving the response");
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}


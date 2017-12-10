package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.InsertingDataException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.dto.Community;
import com.cmpe272.gr15.mysql.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CommunityController extends BornLearningController<Community, CommunityService>{

    @Autowired
    public CommunityController(CommunityService communityService){
        super(communityService);
    }

    @RequestMapping(path = "/community", method = POST)
    public ResponseEntity<Void> addInfrastructureDevResponse(@RequestBody List<Community> community) {
        System.out.println(community);
        if(community.size()<=0){
            throw new InvalidDataException("Cannot save empty responses.");
        } else{
            for (Community comm: community) {
                if (comm.getIndicatorID() == null) {
                    throw new InvalidDataException("Indicator id cannot be blank.");
                }
                else if (comm.getCenterId() == null) {
                    throw new InvalidDataException("Center id cannot be blank.");
                }
                else if (comm.getResponse() ==  null) {
                    throw new InvalidDataException("Response cannot be blank.");
                }
                else if (comm.getAssessmentDate() ==  null) {
                    throw new InvalidDataException("Assessment Date cannot be blank.");
                }
            }
            try {
                databaseService.save(community);
            }
            catch(Exception e) {
                System.out.println("exception occured"+ e);
                throw new InsertingDataException("Error occurred while saving the response");
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

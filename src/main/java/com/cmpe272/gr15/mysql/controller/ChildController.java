package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.DataProcessingException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.dto.Child;
import com.cmpe272.gr15.mysql.service.ChildService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
    import static org.springframework.web.bind.annotation.RequestMethod.POST;

    @RestController
    @RequestMapping("/children")
    public class ChildController extends BornLearningController<Child, ChildService>{

    @Autowired
    public ChildController(ChildService childService) {
        super(childService);
    }

    @Override
    @RequestMapping(method = GET)
    public ResponseEntity<List<Child>> getAll() {
        return super.getAll();
    }

    @RequestMapping(path = "/byCenterId/{centerId}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Child>> getByCenterId(@PathVariable Integer centerId) throws ParseException {
        List<com.cmpe272.gr15.mysql.model.dto.Child> children = databaseService.getChildByCenterID(centerId);
        if (children == null) {
            //throw new DataNotFoundException("No Center associated to: " + centerId.toString());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(children, HttpStatus.OK);
    }

    @RequestMapping(path = "/byChildId/{childId}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Child> getChildInfoByChildId(@PathVariable Integer childId) {
        Child child = null;
        try {
            child = databaseService.getChildInfoByChildID(childId);
        } catch (ParseException errParse) {
            throw new DataProcessingException("An error occurred when parsing child object." + errParse.getMessage());
        }
        if (child == null) {
            throw new DataNotFoundException("No Child associated to: " + childId.toString());
        }
        return new ResponseEntity<>(child, HttpStatus.OK);
    }

    @RequestMapping(path = "/addChild",method = POST)
    public ResponseEntity<Void> addChild(@RequestBody Child child) {
        if (StringUtils.isBlank(child.getChildID().toString())) {
            throw new InvalidDataException("child id cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getChildFName())) {
            throw new InvalidDataException("child first name cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getGender())) {
            throw new InvalidDataException("child gender cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getChildDOB().toString())) {
            throw new InvalidDataException("child birth date cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getGuardianName())) {
            throw new InvalidDataException("child guardian name cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getGuardianPhone())) {
            throw new InvalidDataException("child guardian phone cannot be blank.");
        }
        else if (StringUtils.isBlank(child.getCenterID().toString())) {
            throw new InvalidDataException("Center Id cannot be blank.");
        }
        /*

        else if (StringUtils.isBlank(child.getActive())) {
            throw new InvalidDataException("child gender cannot be blank.");
        }
        */
        else {
            databaseService.save(child);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

        @RequestMapping(path = "/updateChild",method = RequestMethod.PUT)
        public ResponseEntity<Void> updateChild(@RequestBody Child child) {
        System.out.print("Child update API called");
//            if (StringUtils.isBlank(child.getChildFName())) {
//                throw new InvalidDataException("child first name cannot be blank.");
//            }
//            else if (StringUtils.isBlank(child.getGender())) {
//                throw new InvalidDataException("child gender cannot be blank.");
//            }
//            else if (StringUtils.isBlank(child.getChildDOB().toString())) {
//                throw new InvalidDataException("child birth date cannot be blank.");
//            }
//            else if (StringUtils.isBlank(child.getGuardianName())) {
//                throw new InvalidDataException("child guardian name cannot be blank.");
//            }
//            else if (StringUtils.isBlank(child.getGuardianPhone())) {
//                throw new InvalidDataException("child guardian phone cannot be blank.");
//            }
//            else if (StringUtils.isBlank(child.getCenterID().toString())) {
//                throw new InvalidDataException("Center Id cannot be blank.");
//            }
        /*
        else if (StringUtils.isBlank(child.getActive())) {
            throw new InvalidDataException("child gender cannot be blank.");
        }
        */
//            else {
                databaseService.update(child);
//            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

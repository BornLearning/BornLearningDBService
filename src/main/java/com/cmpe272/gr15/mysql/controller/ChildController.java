package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.Child;
import com.cmpe272.gr15.mysql.model.ChildAge;
import com.cmpe272.gr15.mysql.service.ChildService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity<List<ChildAge>> getByCenterId(@PathVariable Integer centerId) throws ParseException {
        List<Child> child = databaseService.getChildByCenterID(centerId);
        List<ChildAge> childAge=new ArrayList<>();
        if (child == null) {
            //throw new DataNotFoundException("No Center associated to: " + centerId.toString());
            return new ResponseEntity<>(childAge, HttpStatus.OK);
        }
        Date d1 = new Date();
        System.out.println(d1);
        for(int i=0;i<child.size();i++){
            ChildAge childTemp=new ChildAge();
            Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse((String)child.get(i).getChildDOB());
            long diff = Math.abs(d1.getTime() - d2.getTime());
            long diffDays = diff / (24 * 60 * 60 * 1000);
            int age = Integer.parseInt(""+(diffDays/365));
            System.out.println(d2);
            childTemp.setChildID(child.get(i).getChildID());
            childTemp.setChildFName(child.get(i).getChildFName());
            childTemp.setChildLName(child.get(i).getChildLName());
            childTemp.setChildDOB(child.get(i).getChildDOB());
            childTemp.setGender(child.get(i).getGender());
            childTemp.setGuardianName(child.get(i).getGuardianName());
            childTemp.setGuardianPhone(child.get(i).getGuardianPhone());
            childTemp.setCenterID(child.get(i).getCenterID());
            childTemp.setImageID(child.get(i).getImageID());
            childTemp.setActive(child.get(i).getActive());
            childTemp.setAge(age);
            childAge.add(childTemp);
        }
        return new ResponseEntity<>(childAge, HttpStatus.OK);
    }

    @RequestMapping(path = "/byChildId/{childId}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Child> getChildInfoByChildId(@PathVariable Integer childId) {
        try {
            Child child = databaseService.getChildInfoByChildID(childId);
            if (child == null) {
                throw new DataNotFoundException("No Child associated to: " + childId.toString());
            }

            return new ResponseEntity<>(child, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Child(), HttpStatus.OK);
        }
    }

    @RequestMapping(path = "/addChildInfo",method = POST)
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
}

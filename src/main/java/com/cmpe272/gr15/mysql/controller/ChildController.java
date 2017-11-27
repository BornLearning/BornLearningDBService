package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.model.Child;
import com.cmpe272.gr15.mysql.service.ChildService;
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
    public ResponseEntity<List<Child>> getByCenterId(@PathVariable Integer centerId) {
        List<Child> child = databaseService.getChildByCenterID(centerId);
        if (child == null) {
            throw new DataNotFoundException("No Center associated to: " + centerId.toString());
        }
        return new ResponseEntity<>(child, HttpStatus.OK);
    }
    @RequestMapping(path = "/byChildId/{childId}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Child> getChildInfoByChildId(@PathVariable Integer childId) {
        Child child = databaseService.getChildInfoByChildID(childId);
        if (child == null) {
            throw new DataNotFoundException("No Child associated to: " + childId.toString());
        }
        return new ResponseEntity<>(child, HttpStatus.OK);
    }
}
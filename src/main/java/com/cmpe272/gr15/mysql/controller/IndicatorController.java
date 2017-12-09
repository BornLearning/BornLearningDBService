package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
//import com.cmpe272.gr15.mysql.model.dto.Indicator;
import com.cmpe272.gr15.mysql.model.Indicator;
import com.cmpe272.gr15.mysql.model.SchoolReadiness;
import com.cmpe272.gr15.mysql.model.InfrastructureDev;
import com.cmpe272.gr15.mysql.service.IndicatorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/indicators")
public class IndicatorController extends BornLearningController<Indicator, IndicatorService>{

    @Autowired
    public IndicatorController(IndicatorService indicatorService) {
        super(indicatorService);
    }

    /**
     * Get Indicator by Subcategory and Age.
     * @param subCategory, age
     * @return
     */
    @RequestMapping(path = "/questions", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Indicator>> getBySubCategory(@RequestParam(name = "subCategory", required = false) String subCategory,
                                                            @RequestParam(name = "ageGroup", required = false) Integer ageGroup) {
        System.out.println("subString is11"+ subCategory);
        System.out.println("agegroup is11"+ ageGroup);
        List<Indicator> indicator = databaseService.getIndicatorBySubCategory(subCategory, ageGroup);
        if (indicator == null) {
            throw new DataNotFoundException("No Indicator associated to: " + subCategory);
        }
        return new ResponseEntity<>(indicator, HttpStatus.OK);
    }

    @RequestMapping(path = "/schoolReadiness", method = POST)
    public ResponseEntity<Void> addSchoolReadinessResponse(@RequestBody SchoolReadiness school) {
//        List<Indicator> indicator = databaseService.getIndicatorBySubCategory(subCategory, ageGroup);
//        if (indicator == null) {
//            throw new DataNotFoundException("No Indicator associated to: " + subCategory);
//        }
        System.out.println("call done" + school);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

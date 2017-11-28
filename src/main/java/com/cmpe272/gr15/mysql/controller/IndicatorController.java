package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
//import com.cmpe272.gr15.mysql.model.dto.Indicator;
import com.cmpe272.gr15.mysql.model.Indicator;
import com.cmpe272.gr15.mysql.service.IndicatorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(path = "/{subCategory}/{ageGroup}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Indicator>> getBySubCategory(@PathVariable String subCategory, @PathVariable Integer ageGroup) {
        List<Indicator> indicator = databaseService.getIndicatorBySubCategory(subCategory, ageGroup);
        if (indicator == null) {
            throw new DataNotFoundException("No Indicator associated to: " + subCategory);
        }
        return new ResponseEntity<>(indicator, HttpStatus.OK);
    }
}

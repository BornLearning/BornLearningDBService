package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.model.dto.Center;
import com.cmpe272.gr15.mysql.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/centers")
public class CentersController extends BornLearningController<Center, CenterService> {


  @Autowired
  public CentersController(CenterService centerService) {
    super(centerService);
  }


  @Override
  @RequestMapping(method = GET)
  public ResponseEntity<List<Center>> getAll() {
    return super.getAll();
  }
}

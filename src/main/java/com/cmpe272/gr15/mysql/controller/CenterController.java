package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.exceptions.DataNotFoundException;
import com.cmpe272.gr15.mysql.exceptions.InvalidDataException;
import com.cmpe272.gr15.mysql.model.dto.Center;
import com.cmpe272.gr15.mysql.service.CenterService;
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

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/centers")
public class CenterController extends BornLearningController<Center, CenterService> {


  @Autowired
  public CenterController(CenterService centerService) {
    super(centerService);
  }

  @Override
  @RequestMapping(method = GET)
  public ResponseEntity<List<Center>> getAll() {
    return super.getAll();
  }

  /**
   * Get Center by Facilitator ID. Usually this would be entity's own ID i.e. centerId, but since we won't need that,
   * we'll use facilitatorId to retrieve the Centers that belong to that ID.
   * @param facilitatorId
   * @return
   */
  @RequestMapping(path = "/{facilitatorId}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Center>> getByFacilitatorId(@PathVariable Integer facilitatorId) {
    List<Center> center = databaseService.getCenterByFacilitatorId(facilitatorId);
    if (center == null) {
      throw new DataNotFoundException("No Center associated to: " + facilitatorId.toString());
    }
    return new ResponseEntity<>(center, HttpStatus.OK);
  }

  @RequestMapping(method = POST)
  public ResponseEntity<Void> addCenter(@RequestBody Center center) {
    if (StringUtils.isBlank(center.getCenterName())) {
      throw new InvalidDataException("Center name cannot be blank.");
    }
    databaseService.save(center);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}

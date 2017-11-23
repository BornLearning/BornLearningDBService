package com.cmpe272.gr15.mysql;

import com.cmpe272.gr15.mysql.model.dto.Center;
import com.cmpe272.gr15.mysql.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
  @RequestMapping(path = "/{facilitatorId}", method = GET)
  public ResponseEntity<List<Center>> getByFacilitatorId(@PathVariable Integer facilitatorId) {
    List<Center> center = databaseService.getCenterByFacilitatorId(facilitatorId);
    return center != null ? new ResponseEntity<>(center, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

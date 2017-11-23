package com.cmpe272.gr15.mysql;

import com.cmpe272.gr15.mysql.service.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Base class for all the controllers that will serve as API to retrieve entities. All Database related controllers
 * must extend this class.
 * @param <D>
 * @param <S>
 */
public abstract class BornLearningController<D, S extends DatabaseService> {

    protected S databaseService;

    public BornLearningController(S databaseService) {
        this.databaseService = databaseService;
    }

    public ResponseEntity<List<D>> getAll() {
        return new ResponseEntity<List<D>>(databaseService.getAll(), HttpStatus.OK);
    }

}

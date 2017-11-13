package com.cmpe272.gr15.mysql.controller;

import com.cmpe272.gr15.mysql.service.DatabaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BornLearningController<D, S extends DatabaseService> {

    private S databaseService;

    public BornLearningController(S databaseService) {
        this.databaseService = databaseService;
    }

    public ResponseEntity<List<D>> getAll() {
        return new ResponseEntity<List<D>>(databaseService.getAll(), HttpStatus.OK);
    }

}

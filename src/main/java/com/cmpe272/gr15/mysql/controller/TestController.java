package com.cmpe272.gr15.mysql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("Hello World!!", HttpStatus.OK);
    }
}

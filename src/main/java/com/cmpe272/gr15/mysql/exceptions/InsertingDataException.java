package com.cmpe272.gr15.mysql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InsertingDataException extends RuntimeException {

    public InsertingDataException(String message) {

        super(message);
    }
}

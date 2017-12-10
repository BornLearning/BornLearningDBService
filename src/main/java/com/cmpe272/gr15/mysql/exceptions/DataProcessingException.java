package com.cmpe272.gr15.mysql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message) {
        super(message);
    }
}

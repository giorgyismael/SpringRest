package com.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceprion extends  RuntimeException {
    public ResourceNotFoundExceprion(String exception){
        super(exception);
    }
}

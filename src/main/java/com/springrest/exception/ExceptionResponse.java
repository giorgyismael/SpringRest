package com.springrest.exception;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String details;
}

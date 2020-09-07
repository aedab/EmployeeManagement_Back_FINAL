package com.ausytechnologies.employeemanagement_backend.Exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private Throwable exception;


    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp, Throwable exception) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        // this.exception = exception.fillInStackTrace();
    }

    private final ZonedDateTime timestamp;

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}

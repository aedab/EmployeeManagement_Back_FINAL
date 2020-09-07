package com.ausytechnologies.employeemanagement_backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiException apiError)
    {
        return new ResponseEntity<>(apiError,apiError.getHttpStatus());
    }

    @ExceptionHandler(ErrorNotFound.class)
    public ResponseEntity<Object> handleApiRequestException(ErrorNotFound e, HttpServletResponse httpServletResponse){

        HttpStatus internalError = HttpStatus.NOT_FOUND;
        httpServletResponse.setStatus(internalError.value());

        ApiException apiException = new ApiException(
                "Entity has not been found!", internalError,
                ZonedDateTime.now(ZoneId.of("Z")), e);

        return buildResponseEntity(apiException);

        // return new ResponseEntity<>(apiException,internalError);

    }

}
package com.trainingapps.jobms.jobms.controller;

import com.trainingapps.jobms.jobms.exceptions.InvalidJobTypeException;
import com.trainingapps.jobms.jobms.exceptions.JobNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

/**
 *   Centralized Exception handler class
 */

@Component
@RestController
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {
            InvalidJobTypeException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            JobNotFoundException.class
    })
    public String handleInvalidException(Exception e) {

        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JobNotFoundException.class)
    public String handleNotFoundException(Exception e) {

        return e.getMessage();
    }

}

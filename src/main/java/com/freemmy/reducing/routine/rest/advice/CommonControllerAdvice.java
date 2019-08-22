package com.freemmy.reducing.routine.rest.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Date: 20/08/19
 *
 * @author Dzmitry Dziokin
 */
@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleRequestNotFoundException(NoSuchElementException exception) {
        log.info("Element is not found");
        Map<String, String> error = new HashMap<>();
        error.put("code", "ENTITY_NOT_FOUND");
        error.put("errorDescription", "Requested entity not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

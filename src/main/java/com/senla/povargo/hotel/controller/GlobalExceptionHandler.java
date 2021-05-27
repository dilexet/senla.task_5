package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleInvalidException(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-1, "System error", e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Response> handleValidationException(ValidationException e) {
        logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-2, "Validation error", e.getMessage()));
    }
}

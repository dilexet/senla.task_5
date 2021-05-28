package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.BindingError;
import com.senla.povargo.hotel.tools.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String VALID_ERROR = "Validation error";
    private static final String SYSTEM_ERROR = "System error";
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleInvalidException(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-1, SYSTEM_ERROR, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var result = BindingError.getErrors(ex.getBindingResult());
        logger.error(result);
        return ResponseEntity.ok(new Response(-2, VALID_ERROR, result));
    }
}

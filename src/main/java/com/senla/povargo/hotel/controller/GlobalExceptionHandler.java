package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.Logger;
import com.senla.povargo.hotel.tools.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleInvalidException(Exception e) {
        Logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-1, "System error", e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Response> handleValidationException(ValidationException e) {
        Logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-2, "Validation error", e.getMessage()));
    }
}

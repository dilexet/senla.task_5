package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleInvalidException(Exception e) {
        Logger.error(e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }
}

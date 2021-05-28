package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.BindingError;
import com.senla.povargo.hotel.tools.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var result = BindingError.getErrors(ex.getBindingResult());
        logger.error(result);
        return ResponseEntity.ok(new Response(-2, "Validation error", result));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleInvalidException(Exception e) {
        logger.error(e.getMessage());
        return ResponseEntity.ok(new Response(-1, "System error", e.getMessage()));
    }
}

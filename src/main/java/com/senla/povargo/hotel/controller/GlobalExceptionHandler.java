package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.Response;
import com.senla.povargo.hotel.tools.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final String VALID_ERROR = "Validation error";
    private static final String SYSTEM_ERROR = "System error";

    @Autowired
    Translator translator;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleInvalidException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(new Response(-1, SYSTEM_ERROR, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errors = ex.getAllErrors().stream().map(er -> translator.toLocale(er.getDefaultMessage())).collect(Collectors.toList());
        log.error(errors.toString());
        return ResponseEntity.ok(new Response(-2, VALID_ERROR, errors));
    }
}

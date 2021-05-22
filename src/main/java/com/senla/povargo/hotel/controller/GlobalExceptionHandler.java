package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.tools.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleInvalidException(Exception e) {
        Logger.error(e.getMessage());
        return e.getMessage();
    }
}

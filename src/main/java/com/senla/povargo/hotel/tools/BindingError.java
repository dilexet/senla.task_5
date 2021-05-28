package com.senla.povargo.hotel.tools;

import org.springframework.validation.BindingResult;

public class BindingError {
    public static String getErrors(BindingResult bindingResult) {
        StringBuilder errors = new StringBuilder();
        for (var error : bindingResult.getFieldErrors()) {
            errors.append(error.getDefaultMessage()).append(";");
        }
        return errors.toString();
    }
}
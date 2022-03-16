package com.m.reza.khorasany.participant.domain.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class InputValidationException extends RuntimeException {
    private final BindingResult bindingResult;
}

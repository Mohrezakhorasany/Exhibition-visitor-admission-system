package com.m.reza.khorasany.participant.controller.exception;

import com.m.reza.khorasany.participant.domain.dto.output.exception.ExceptionOutputDto;
import com.m.reza.khorasany.participant.domain.dto.output.exception.InvalidFieldOutputDto;
import com.m.reza.khorasany.participant.domain.exception.EntityNotFoundException;
import com.m.reza.khorasany.participant.domain.exception.InputValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static List<InvalidFieldOutputDto> convertErroneousFields(final Errors errors) {
        return errors.getFieldErrors()
                .stream()
                .map(InvalidFieldOutputDto::new)
                .toList();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionOutputDto handleRuntimeException(final Exception ignored) {
        return new ExceptionOutputDto(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error. :(");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionOutputDto handleEntityNotFoundException(final EntityNotFoundException entityNotFoundException) {
        return new ExceptionOutputDto(HttpStatus.NOT_FOUND, entityNotFoundException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionOutputDto> handleEntityNotFoundException(final MethodArgumentNotValidException methodArgumentNotValidException) {
        return ResponseEntity.badRequest()
                .body(new ExceptionOutputDto(HttpStatus.BAD_REQUEST,
                        "Invalid validation error!",
                        convertErroneousFields(methodArgumentNotValidException.getBindingResult())));
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ExceptionOutputDto> handleEntityNotFoundException(final InputValidationException inputValidationException) {
        return ResponseEntity.badRequest()
                .body(new ExceptionOutputDto(HttpStatus.BAD_REQUEST,
                        "Invalid validation error!",
                        convertErroneousFields(inputValidationException.getBindingResult())));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionOutputDto> handleEntityNotFoundException(final ConstraintViolationException constraintViolationException) {
        return ResponseEntity.badRequest()
                .body(new ExceptionOutputDto(HttpStatus.BAD_REQUEST,
                        "Invalid validation error!",
                        constraintViolationException.getConstraintViolations()
                                .stream()
                                .map(constraintViolation -> new InvalidFieldOutputDto(constraintViolation.getPropertyPath().toString(),
                                        constraintViolation.getMessage()))
                                .toList()));
    }
}

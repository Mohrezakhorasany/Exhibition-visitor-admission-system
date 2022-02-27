package hu.ak_akademia.spring_boot_rest.controller.exception;

import hu.ak_akademia.spring_boot_rest.domain.dto.output.exception.ExceptionOutputDto;
import hu.ak_akademia.spring_boot_rest.domain.dto.output.exception.InvalidFieldOutputDto;
import hu.ak_akademia.spring_boot_rest.domain.exception.EntityNotFoundException;
import hu.ak_akademia.spring_boot_rest.domain.exception.InputValidationException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static List<InvalidFieldOutputDto> convertErrorsFields(final Errors errors) {
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
                        convertErrorsFields(methodArgumentNotValidException.getBindingResult())));
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ExceptionOutputDto> handleEntityNotFoundException(final InputValidationException inputValidationException) {
        return ResponseEntity.badRequest()
                .body(new ExceptionOutputDto(HttpStatus.BAD_REQUEST,
                        "Invalid validation error!",
                        convertErrorsFields(inputValidationException.getBindingResult())));
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

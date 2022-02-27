package hu.ak_akademia.spring_boot_rest.domain.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class InputValidationException extends RuntimeException {
    private final BindingResult bindingResult;
}

package hu.ak_akademia_spring_data_jpa_crud.domain.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class InputValidationException extends RuntimeException {
    private final BindingResult bindingResult;
}

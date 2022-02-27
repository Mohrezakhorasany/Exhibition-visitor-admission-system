package hu.ak_akademia.spring_boot_rest.domain.dto.output.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

@Data
@RequiredArgsConstructor
@JsonPropertyOrder({"fieldName", "errorMessage"})
public class InvalidFieldOutputDto {
    private final String fieldName;
    private final String errorMessage;

    public InvalidFieldOutputDto(final FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}


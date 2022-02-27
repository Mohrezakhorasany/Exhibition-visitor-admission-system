package hu.ak_akademia.spring_boot_rest.domain.dto.output.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Data
@JsonPropertyOrder({"statusCode", "errorMessage", "invalidFields"})
public class ExceptionOutputDto {
    @JsonProperty
    private final List<InvalidFieldOutputDto> invalidFields;
    @JsonProperty
    private Integer statusCode;
    @JsonProperty
    private String errorMessage;

    public ExceptionOutputDto(final HttpStatus httpStatus,
                              final String errorMessage) {
        this(httpStatus, errorMessage, Collections.emptyList());
    }

    public ExceptionOutputDto(final HttpStatus httpStatus,
                              final String errorMessage,
                              final List<InvalidFieldOutputDto> invalidFields) {
        statusCode = httpStatus.value();
        this.errorMessage = errorMessage;
        this.invalidFields = Collections.unmodifiableList(invalidFields);
    }
}

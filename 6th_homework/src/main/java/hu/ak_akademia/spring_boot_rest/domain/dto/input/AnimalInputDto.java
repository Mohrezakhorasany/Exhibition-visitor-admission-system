package hu.ak_akademia.spring_boot_rest.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AnimalInputDto {
    @Positive
    private Integer id;
    @NotBlank
    @NotNull
    private String name;
    private String classType;
    private String eatingType;
    private String skinType;

    @JsonCreator
    public AnimalInputDto(@JsonProperty("name") final String name,
                          @JsonProperty("classType") final String classType,
                          @JsonProperty("eatingType") final String eatingType,
                          @JsonProperty("skinType") final String skinType) {
        this.name = name;
        this.classType = classType;
        this.eatingType = eatingType;
        this.skinType = skinType;
    }
}

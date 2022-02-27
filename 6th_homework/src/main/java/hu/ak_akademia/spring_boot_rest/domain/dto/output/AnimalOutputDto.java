package hu.ak_akademia.spring_boot_rest.domain.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;
import lombok.Data;

@Data
public class AnimalOutputDto {
    @JsonProperty
    private final Integer id;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String classType;
    @JsonProperty
    private final String eatingType;
    @JsonProperty
    private final String skinType;

    public AnimalOutputDto(final Animal animal) {
        id = animal.getId();
        name = animal.getName();
        classType = animal.getClassType();
        eatingType = animal.getEatingType();
        skinType = animal.getSkinType();
    }
}

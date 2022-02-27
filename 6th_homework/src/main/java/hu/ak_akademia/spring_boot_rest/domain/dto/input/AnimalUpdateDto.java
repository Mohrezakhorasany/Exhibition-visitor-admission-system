package hu.ak_akademia.spring_boot_rest.domain.dto.input;

import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class AnimalUpdateDto {
    @Positive
    private Integer id;
    @NotBlank
    @NotNull
    private String name;
    private String classType;
    private String eatingType;
    private String skinType;

    public AnimalUpdateDto(final Animal animal) {
        id = animal.getId();
        name = animal.getName();
        classType = animal.getClassType();
        eatingType = animal.getEatingType();
        skinType = animal.getSkinType();
    }
}

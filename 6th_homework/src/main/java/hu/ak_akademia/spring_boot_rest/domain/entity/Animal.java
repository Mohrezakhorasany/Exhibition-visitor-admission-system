package hu.ak_akademia.spring_boot_rest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    private Integer id;
    private String name;
    private String classType;
    private String eatingType;
    private String skinType;
}

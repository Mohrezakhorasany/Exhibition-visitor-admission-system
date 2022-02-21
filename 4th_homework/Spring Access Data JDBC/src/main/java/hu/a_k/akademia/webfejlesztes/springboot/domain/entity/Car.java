package hu.a_k.akademia.webfejlesztes.springboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Car {
    private Integer registrationId;
    private String brand;
    private String model;
    private String fuelType;
    private Date manufacturingDate;
    private String color;
}

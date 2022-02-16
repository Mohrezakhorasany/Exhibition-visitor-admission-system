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
    private Integer registration_id;
    private String brand;
    private String model;
    private String fuel_type;
    private Date manufacturing_date;
    private String color;
}

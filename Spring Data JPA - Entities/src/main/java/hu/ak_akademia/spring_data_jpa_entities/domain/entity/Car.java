package hu.ak_akademia.spring_data_jpa_entities.domain.entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator", sequenceName = "car_seq")
    private Integer id;
    private String brand;
    private String model;
}

package hu.ak_akademia.sping_data_jpa.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String brand;
    private String model;
}

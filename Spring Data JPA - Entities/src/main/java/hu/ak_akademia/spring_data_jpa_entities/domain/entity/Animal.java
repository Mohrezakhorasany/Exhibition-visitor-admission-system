package hu.ak_akademia.spring_data_jpa_entities.domain.entity;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_generator")
    @SequenceGenerator(name = "animal_generator", sequenceName = "animal_seq")
    private Integer id;
    private String classType;
    private String skinType;
}

package hu.ak_akademia.sping_data_jpa.domain.entity;

import org.hibernate.annotations.Check;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Check(constraints = "age >= 0")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
}

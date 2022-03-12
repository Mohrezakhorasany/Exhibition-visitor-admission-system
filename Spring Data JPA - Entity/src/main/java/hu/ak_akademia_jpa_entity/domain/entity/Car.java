package hu.ak_akademia_jpa_entity.domain.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "manufactured_by_date", nullable = false)
    private Date manufacturedDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar soldDate;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Transient
    private boolean resold;
    @Embedded
    private SafetyTest safetyTest;

}

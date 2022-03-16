package com.m.reza.khorasany.participant.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fullName;
    private String email;
    private String company;
    @Temporal(TemporalType.DATE)
    private LocalDateTime admittedDate;
}

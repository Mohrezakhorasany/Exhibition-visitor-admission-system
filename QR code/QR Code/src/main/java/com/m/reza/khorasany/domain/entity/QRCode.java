package com.m.reza.khorasany.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "qr_code")
@Entity
public class QRCode {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

}
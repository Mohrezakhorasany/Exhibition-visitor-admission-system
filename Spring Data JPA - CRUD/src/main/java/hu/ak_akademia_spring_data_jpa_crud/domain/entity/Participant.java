package hu.ak_akademia_spring_data_jpa_crud.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty
    private String fullName;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String company;
    @Temporal(TemporalType.DATE)
    @PastOrPresent
    private Date admittedDate;
}

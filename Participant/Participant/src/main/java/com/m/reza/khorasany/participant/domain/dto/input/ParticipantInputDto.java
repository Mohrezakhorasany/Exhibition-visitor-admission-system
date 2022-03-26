package com.m.reza.khorasany.participant.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Data
public class ParticipantInputDto {

    @NotEmpty
    private final String fullName;
    @Email
    @NotEmpty
    private final String email;
    @NotEmpty
    private final String company;
    @PastOrPresent
    private final LocalDateTime admittedDate;

    @JsonCreator
    public ParticipantInputDto(@JsonProperty("full_name") final String fullName,
                               @JsonProperty("email") final String email,
                               @JsonProperty("company") final String company,
                               @JsonProperty("admitted_date") final LocalDateTime admittedDate) {
        this.fullName = fullName;
        this.email = email;
        this.company = company;
        this.admittedDate = admittedDate;
    }

}

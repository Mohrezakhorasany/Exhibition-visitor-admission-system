package com.m.reza.khorasany.participant.domain.dto.input;

import com.m.reza.khorasany.participant.domain.entity.Participant;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ParticipantUpdateDto {

    @Positive
    @Setter
    private Integer id;
    @NotEmpty
    private String fullName;
    @Email
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private String company;
    @PastOrPresent
    private LocalDateTime admittedDate;

    public ParticipantUpdateDto(final Participant participant) {
        id = participant.getId();
        fullName = participant.getFullName();
        email = participant.getEmail();
        company = participant.getCompany();
        admittedDate = participant.getAdmittedDate();
    }

}

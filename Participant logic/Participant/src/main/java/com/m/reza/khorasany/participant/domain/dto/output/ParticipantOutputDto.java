package com.m.reza.khorasany.participant.domain.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.m.reza.khorasany.participant.domain.entity.Participant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParticipantOutputDto {
    @JsonProperty
    private final Integer id;
    @JsonProperty
    private final String fullName;
    @JsonProperty
    private final String email;
    @JsonProperty
    private final String company;
    @JsonProperty
    private final LocalDateTime admittedDate;

    public ParticipantOutputDto(final Participant participant) {
        id = participant.getId();
        fullName = participant.getFullName();
        email = participant.getEmail();
        company = participant.getCompany();
        admittedDate = participant.getAdmittedDate();
    }
}

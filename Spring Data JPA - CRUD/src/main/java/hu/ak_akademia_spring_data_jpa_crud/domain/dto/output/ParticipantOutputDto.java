package hu.ak_akademia_spring_data_jpa_crud.domain.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import lombok.Data;

import java.util.Date;

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
    private final Date admittedDate;

    public ParticipantOutputDto(final Participant participant) {
        id = participant.getId();
        fullName = participant.getFullName();
        email = participant.getEmail();
        company = participant.getCompany();
        admittedDate = participant.getAdmittedDate();
    }
}

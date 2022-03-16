package hu.ak_akademia_spring_data_jpa_crud.domain.dto.input;

import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ParticipantUpdateDto {

    @Positive
    @Setter
    private final Integer id;
    @NotEmpty
    private final String fullName;
    @Email
    @NotNull
    private final String email;
    @NotEmpty
    @NotNull
    private final String company;
    @PastOrPresent
    private final LocalDateTime admittedDate;

    public ParticipantUpdateDto(final Participant participant) {
        id = participant.getId();
        fullName = participant.getFullName();
        email = participant.getEmail();
        company = participant.getCompany();
        admittedDate = participant.getAdmittedDate();
    }

}

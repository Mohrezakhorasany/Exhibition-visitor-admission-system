package hu.ak_akademia_spring_data_jpa_crud.domain.dto.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

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
    private final Date admittedDate;

    @JsonCreator
    public ParticipantInputDto(@JsonProperty("full_name") final String fullName,
                               @JsonProperty("email") final String email,
                               @JsonProperty("company") final String company,
                               @JsonProperty("admitted_date") final Date admittedDate) {
        this.fullName = fullName;
        this.email = email;
        this.company = company;
        this.admittedDate = admittedDate;
    }
}

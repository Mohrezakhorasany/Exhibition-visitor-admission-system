package hu.ak_akademia_spring_data_jpa_crud.service.api;

import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant save(@NotNull Participant participant);

    Optional<Participant> findById(@NotNull @Positive Integer id);

    List<Participant> findAll();

    Participant update(@NotNull Participant participant);

    void delete(@NotNull Integer id);
}

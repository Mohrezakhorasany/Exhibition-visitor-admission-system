package hu.ak_akademia_spring_data_jpa_crud.service.api;

import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;

import java.util.List;
import java.util.Map;

public interface ParticipantService {
    Participant save(Participant participant);

    Participant findById(Integer id);

    List<Participant> findAll();

    void update(final Integer id, final Map<String, Object> parametersToUpdate);

    void delete(Integer id);
}

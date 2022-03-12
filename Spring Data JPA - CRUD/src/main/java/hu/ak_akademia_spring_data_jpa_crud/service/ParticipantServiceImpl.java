package hu.ak_akademia_spring_data_jpa_crud.service;

import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import hu.ak_akademia_spring_data_jpa_crud.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements hu.ak_akademia_spring_data_jpa_crud.service.api.ParticipantService {

    private final Validator validator;
    private ParticipantRepository participantRepository;


    @Override
    public Participant save(@NotNull final Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Optional<Participant> findById(@NotNull @Positive final Integer id) {
        return participantRepository.findById(id);
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public Participant update(@NotNull final Participant participant) {
        return save(participant);
    }

    @Override
    public void delete(@NotNull final Integer id) {
        participantRepository.deleteById(id);
    }
}

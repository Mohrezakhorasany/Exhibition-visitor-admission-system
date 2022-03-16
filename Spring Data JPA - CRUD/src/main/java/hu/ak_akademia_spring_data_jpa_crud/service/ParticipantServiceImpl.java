package hu.ak_akademia_spring_data_jpa_crud.service;

import hu.ak_akademia_spring_data_jpa_crud.domain.dto.input.ParticipantUpdateDto;
import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import hu.ak_akademia_spring_data_jpa_crud.domain.exception.EntityNotFoundException;
import hu.ak_akademia_spring_data_jpa_crud.domain.exception.InputValidationException;
import hu.ak_akademia_spring_data_jpa_crud.domain.exception.UnknownFieldException;
import hu.ak_akademia_spring_data_jpa_crud.repository.ParticipantRepository;
import hu.ak_akademia_spring_data_jpa_crud.service.api.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;
    private Validator validator;


    @Override
    public Participant save(final Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Participant findById(final Integer id) {
        return participantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Participant with id '%d' was not found", id)));
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public void update(final Integer id, final Map<String, Object> parametersToUpdate) {
        final Participant participantFromTheDatabase = findById(id);
        final ParticipantUpdateDto participantUpdateDto = mapToUpdateDto(parametersToUpdate, participantFromTheDatabase);
        validateFields(participantUpdateDto);
        participantRepository.save(Participant.builder().withId(participantUpdateDto.getId()).withFullName(participantUpdateDto.getFullName()).withEmail(participantUpdateDto.getEmail()).withCompany(participantUpdateDto.getCompany()).withAdmittedDate(participantUpdateDto.getAdmittedDate()).build());
    }

    @Override
    public void delete(final Integer id) {
        participantRepository.deleteById(id);
    }

    private void validateFields(final ParticipantUpdateDto participantUpdateDto) {
        final BeanPropertyBindingResult beanPropertyBindingResult = new BeanPropertyBindingResult(participantUpdateDto, "personUpdateDto");
        validator.validate(participantUpdateDto, beanPropertyBindingResult);
        if (beanPropertyBindingResult.hasErrors()) {
            throw new InputValidationException(beanPropertyBindingResult);
        }
    }

    private ParticipantUpdateDto mapToUpdateDto(final Map<String, Object> parametersToUpdate, final Participant participantFromTheDatabase) {
        final ParticipantUpdateDto participantUpdateDto = new ParticipantUpdateDto(participantFromTheDatabase);
        parametersToUpdate.forEach((field, value) -> {
            switch (field) {
                case "id" -> participantUpdateDto.setId((Integer) value);
                case "fullName" -> participantUpdateDto.setFullName((String) value);
                case "email" -> participantUpdateDto.setEmail((String) value);
                case "company" -> participantUpdateDto.setCompany((String) value);
                case "admittedDate" -> participantUpdateDto.setAdmittedDate((LocalDateTime) value);
                default -> throw new UnknownFieldException(String.format("The field '%s' is not known!", field));
            }
        });
        return participantUpdateDto;
    }
}

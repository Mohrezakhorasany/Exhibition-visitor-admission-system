package hu.ak_akademia_spring_data_jpa_crud.controller;

import hu.ak_akademia_spring_data_jpa_crud.domain.dto.input.ParticipantInputDto;
import hu.ak_akademia_spring_data_jpa_crud.domain.dto.output.ParticipantOutputDto;
import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import hu.ak_akademia_spring_data_jpa_crud.service.api.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ParticipantControllerImpl implements hu.ak_akademia_spring_data_jpa_crud.controller.api.ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @Override
    public ResponseEntity<?> save(final ParticipantInputDto participantInputDto) {
        final Participant participant = new Participant();
        participant.setFullName(participantInputDto.getFullName());
        participant.setEmail(participantInputDto.getEmail());
        participant.setCompany(participantInputDto.getCompany());
        participant.setAdmittedDate(participantInputDto.getAdmittedDate());
        participantService.save(participant);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(participant.getId())
                        .toUri())
                .build();

    }

    @Override
    public ResponseEntity<ParticipantOutputDto> findById(final Integer id) {
        final Optional<Participant> participant = participantService.findById(id);
        return participant.map(value -> ResponseEntity.ok(new ParticipantOutputDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<ParticipantOutputDto>> findAll() {
        return ResponseEntity.ok(participantService.findAll()
                .stream()
                .map(ParticipantOutputDto::new)
                .toList());
    }

    @Override
    public ResponseEntity<?> update(final ParticipantInputDto ParticipantInputDto) {
        return save(ParticipantInputDto);
    }

    @Override
    public ResponseEntity<?> delete(final Integer id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

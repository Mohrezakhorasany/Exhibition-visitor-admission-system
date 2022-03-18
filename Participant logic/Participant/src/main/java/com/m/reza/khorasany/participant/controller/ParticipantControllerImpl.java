package com.m.reza.khorasany.participant.controller;

import com.m.reza.khorasany.participant.controller.api.ParticipantController;
import com.m.reza.khorasany.participant.domain.dto.input.ParticipantInputDto;
import com.m.reza.khorasany.participant.domain.dto.output.ParticipantOutputDto;
import com.m.reza.khorasany.participant.domain.entity.Participant;
import com.m.reza.khorasany.participant.service.api.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ParticipantControllerImpl implements ParticipantController {

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
        final Participant participant = participantService.findById(id);
        return ResponseEntity.ok(new ParticipantOutputDto(participant));
    }

    @Override
    public ResponseEntity<List<ParticipantOutputDto>> findAll() {
        return ResponseEntity.ok(participantService.findAll()
                .stream()
                .map(ParticipantOutputDto::new)
                .toList());
    }

    @Override
    public ResponseEntity<?> update(final Integer id, final Map<String, Object> values) {
        participantService.update(id, values);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> delete(final Integer id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

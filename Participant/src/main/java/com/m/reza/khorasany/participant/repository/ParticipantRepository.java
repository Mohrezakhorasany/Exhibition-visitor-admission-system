package com.m.reza.khorasany.participant.repository;

import com.m.reza.khorasany.participant.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
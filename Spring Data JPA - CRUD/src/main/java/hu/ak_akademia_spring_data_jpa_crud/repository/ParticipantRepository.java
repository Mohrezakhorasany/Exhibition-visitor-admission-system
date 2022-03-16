package hu.ak_akademia_spring_data_jpa_crud.repository;

import hu.ak_akademia_spring_data_jpa_crud.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
package hu.ak_akademia.spring_data_jpa_entities.repository;

import hu.ak_akademia.spring_data_jpa_entities.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
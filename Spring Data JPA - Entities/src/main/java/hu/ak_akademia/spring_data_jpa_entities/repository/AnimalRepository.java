package hu.ak_akademia.spring_data_jpa_entities.repository;

import hu.ak_akademia.spring_data_jpa_entities.domain.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
package hu.ak_akademia.sping_data_jpa.repository;

import hu.ak_akademia.sping_data_jpa.domain.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
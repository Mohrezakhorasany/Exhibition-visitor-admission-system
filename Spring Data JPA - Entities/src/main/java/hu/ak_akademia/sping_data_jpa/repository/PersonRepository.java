package hu.ak_akademia.sping_data_jpa.repository;

import hu.ak_akademia.sping_data_jpa.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
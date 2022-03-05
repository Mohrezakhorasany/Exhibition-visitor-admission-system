package hu.ak_akademia.sping_data_jpa.repository;

import hu.ak_akademia.sping_data_jpa.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
package hu.ak_akademia_jpa.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    
}
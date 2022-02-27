package hu.ak_akademia.spring_boot_rest.repository.api;

import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    int save(Animal animal);

    Optional<Animal> fetchById(Integer id);

    int update(Animal animal);

    void delete(Integer id);

    List<Animal> fetchAll();
}

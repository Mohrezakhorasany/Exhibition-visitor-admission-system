package hu.ak_akademia.spring_boot_rest.service.api;

import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;

import java.util.List;
import java.util.Map;

public interface AnimalService {
    int save(Animal animal);

    void update(Integer id, Map<String, Object> parametersToUpdate);

    Animal fetchById(Integer id);

    List<Animal> fetchAll();

    void delete(Integer id);
}

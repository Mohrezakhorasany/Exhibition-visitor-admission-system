package hu.ak_akademia.spring_boot_rest.controller;

import hu.ak_akademia.spring_boot_rest.controller.api.AnimalController;
import hu.ak_akademia.spring_boot_rest.domain.dto.input.AnimalInputDto;
import hu.ak_akademia.spring_boot_rest.domain.dto.output.AnimalOutputDto;
import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;
import hu.ak_akademia.spring_boot_rest.service.api.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AnimalControllerImpl implements AnimalController {
    private final AnimalService animalService;

    @Override
    public ResponseEntity<?> save(final AnimalInputDto animalInputDto) {
        final Animal animal = new Animal();
        animal.setName(animalInputDto.getName());
        animal.setClassType(animalInputDto.getClassType());
        animal.setEatingType(animalInputDto.getEatingType());
        animal.setSkinType(animalInputDto.getSkinType());
        int newAnimalId = animalService.save(animal);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAnimalId).toUri()).build();
    }

    @Override
    public ResponseEntity<List<AnimalOutputDto>> fetchAll() {
        return ResponseEntity.ok(animalService.fetchAll()
                .stream()
                .map(AnimalOutputDto::new)
                .toList());
    }

    @Override
    public ResponseEntity<AnimalOutputDto> fetchById(final Integer id) {
        final Animal animal = animalService.fetchById(id);
        return ResponseEntity.ok(new AnimalOutputDto(animal));
    }

    @Override
    public ResponseEntity<?> delete(final Integer id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> patch(final Integer id, final Map<String, Object> parametersToUpdate) {
        animalService.update(id, parametersToUpdate);
        return ResponseEntity.noContent().build();
    }
}

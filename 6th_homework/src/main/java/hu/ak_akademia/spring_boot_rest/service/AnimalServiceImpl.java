package hu.ak_akademia.spring_boot_rest.service;


import hu.ak_akademia.spring_boot_rest.domain.dto.input.AnimalUpdateDto;
import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;
import hu.ak_akademia.spring_boot_rest.domain.exception.EntityNotFoundException;
import hu.ak_akademia.spring_boot_rest.domain.exception.InputValidationException;
import hu.ak_akademia.spring_boot_rest.domain.exception.UnknownFieldException;
import hu.ak_akademia.spring_boot_rest.repository.api.AnimalRepository;
import hu.ak_akademia.spring_boot_rest.service.api.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final Validator validator;

    private static AnimalUpdateDto mapToUpdateDto(final Map<String, Object> parametersToUpdate, final Animal animalFromTheDatabase) {
        final AnimalUpdateDto animalUpdateDto = new AnimalUpdateDto(animalFromTheDatabase);
        parametersToUpdate.forEach((field, value) -> {
            switch (field) {
                case "id" -> animalUpdateDto.setId((Integer) value);
                case "name" -> animalUpdateDto.setName((String) value);
                case "classType" -> animalUpdateDto.setClassType((String) value);
                case "eatingType" -> animalUpdateDto.setEatingType((String) value);
                case "skinType" -> animalUpdateDto.setSkinType((String) value);
                default -> throw new UnknownFieldException(String.format("The field '%s' is not known!", field));
            }
        });
        return animalUpdateDto;
    }

    @Override
    public int save(final Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void update(final Integer id, final Map<String, Object> parametersToUpdate) {
        final Animal animalFromDatabase = fetchById(id);
        final AnimalUpdateDto animalUpdateDto = mapToUpdateDto(parametersToUpdate, animalFromDatabase);
        validateFields(animalUpdateDto);
        animalRepository.update(Animal.builder()
                .withId(animalUpdateDto.getId())
                .withName(animalUpdateDto.getName())
                .withClassType(animalUpdateDto.getClassType())
                .withEatingType(animalUpdateDto.getEatingType())
                .withSkinType(animalUpdateDto.getSkinType())
                .build());
    }

    @Override
    public Animal fetchById(final Integer id) {
        return animalRepository.fetchById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal with id '%d' was not found", id)));
    }

    @Override
    public List<Animal> fetchAll() {
        return animalRepository.fetchAll();
    }

    @Override
    public void delete(final Integer id) {
        animalRepository.delete(id);
    }

    private void validateFields(final AnimalUpdateDto animalUpdateDto) {
        final BeanPropertyBindingResult beanPropertyBindingResult = new BeanPropertyBindingResult(animalUpdateDto, "animalUpdateDto");
        validator.validate(animalUpdateDto, beanPropertyBindingResult);
        if (beanPropertyBindingResult.hasErrors()) {
            throw new InputValidationException(beanPropertyBindingResult);
        }
    }

}

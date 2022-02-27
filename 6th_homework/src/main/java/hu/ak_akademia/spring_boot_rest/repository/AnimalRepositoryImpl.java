package hu.ak_akademia.spring_boot_rest.repository;

import hu.ak_akademia.spring_boot_rest.domain.entity.Animal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class AnimalRepositoryImpl implements hu.ak_akademia.spring_boot_rest.repository.api.AnimalRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public AnimalRepositoryImpl(final NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                                @Qualifier("simpleJdbcInsertAnimal") final SimpleJdbcInsert simpleJdbcInsert) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    @Override
    public int update(final Animal animal) {
        return namedParameterJdbcTemplate.update("""
                        UPDATE zoo.animal
                        SET animal_name = :name,
                            animal_classes = :classType,
                            animal_eating_type = :eatingType,
                            animal_skin_type = :skinType
                        WHERE animal_id = :id
                        """,
                Map.of("id", animal.getId(),
                        "name", animal.getName(),
                        "classType", animal.getClassType(),
                        "age", animal.getEatingType(),
                        "address", animal.getSkinType()));

    }

    @Override
    public int save(final Animal animal) {
        final MapSqlParameterSource parameterSource =
                new MapSqlParameterSource("animal_name", animal.getName())
                        .addValue("animal_classes", animal.getClassType())
                        .addValue("animal_eating_type", animal.getEatingType())
                        .addValue("animal_skin_type", animal.getSkinType());
        return simpleJdbcInsert.executeAndReturnKey(parameterSource)
                .intValue();
    }

    @Override
    public void delete(final Integer id) {
        namedParameterJdbcTemplate.update("""
                        DELETE FROM zoo.animal
                        WHERE animal_id = :id
                        """,
                Map.of("id", id));
    }

    @Override
    public Optional<Animal> fetchById(final Integer id) {
        try {
            return Optional.ofNullable(
                    namedParameterJdbcTemplate.queryForObject("""
                                    SELECT animal_id AS id,
                                           animal_name AS name,
                                           animal_classes AS classType,
                                           animal_eating_type AS eatingType,
                                           animal_skin_type AS skinType
                                    FROM zoo.animal
                                    WHERE animal_id = :parameterId
                                    """,
                            new MapSqlParameterSource("parameterId", id),
                            BeanPropertyRowMapper.newInstance(Animal.class)));
        } catch (final EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}


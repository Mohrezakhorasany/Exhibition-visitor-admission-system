package hu.a_k.akademia.webfejlesztes.springboot.repository;

import hu.a_k.akademia.webfejlesztes.springboot.domain.entity.Car;
import hu.a_k.akademia.webfejlesztes.springboot.domain.exception.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarRepositoryImpl implements hu.a_k.akademia.webfejlesztes.springboot.repository.api.CarRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public CarRepositoryImpl(final NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                             @Qualifier("simpleJdbcInsertCar") final SimpleJdbcInsert simpleJdbcInsert) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    @Override
    public void save(final Car car) {
        try {
            simpleJdbcInsert.execute(new MapSqlParameterSource("car_brand", car.getBrand())
                    .addValue("car_model", car.getModel())
                    .addValue("fuel_type", car.getFuelType())
                    .addValue("manufacturing_date", car.getManufacturingDate())
                    .addValue("car_color", car.getColor()));
        } catch (final DuplicateKeyException e) {
            throw new EntityAlreadyExistsException("Car already exits", e);
        }
    }

    @Override
    public Optional<Car> findByRegID(final Integer id) {
        try {
            return Optional.ofNullable(
                    namedParameterJdbcTemplate.queryForObject("""
                                    SELECT car_brand AS brand,
                                           car_model AS model,
                                           fuel_type AS fuelType,
                                           manufacturing_date AS manufacturingDate,
                                           car_color AS color
                                    FROM factory.car
                                    WHERE registration_id = :parameterRegistrationID
                                    """,
                            new MapSqlParameterSource("parameterRegistrationID", id),
                            BeanPropertyRowMapper.newInstance(Car.class)));
        } catch (final EmptyResultDataAccessException e) {
            System.out.println("Car with this Registration ID: " + id + " haven't been found.");
            return Optional.empty();
        }
    }


    @Override
    public boolean setColor(final Integer id, final String color) {
        final int updatedRows = namedParameterJdbcTemplate.update("""
                        UPDATE factory.car
                        SET car_color = :color
                        WHERE registration_id = :registrationId
                        """,
                new BeanPropertySqlParameterSource(Car.builder()
                        .withRegistrationId(id)
                        .withColor(color)
                        .build())
        );
        return updatedRows != 0;
    }

    @Override
    public boolean delete(int id) {
        final int deletedRow = namedParameterJdbcTemplate.update("""
                        DELETE FROM factory.car WHERE registration_id = :registrationId
                        """,
                new BeanPropertySqlParameterSource(Car.builder()
                        .withRegistrationId(id)
                        .build())
        );
        return deletedRow != 0;
    }
}

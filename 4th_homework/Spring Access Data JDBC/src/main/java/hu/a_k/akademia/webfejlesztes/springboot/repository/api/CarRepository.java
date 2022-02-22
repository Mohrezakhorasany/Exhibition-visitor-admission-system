package hu.a_k.akademia.webfejlesztes.springboot.repository.api;

import hu.a_k.akademia.webfejlesztes.springboot.domain.entity.Car;

import java.util.Optional;

public interface CarRepository {
    void save(Car car);

    Optional<Car> findByRegID(Integer id);

    boolean setColor(Integer id, String color);

    boolean delete(final Integer id);
}

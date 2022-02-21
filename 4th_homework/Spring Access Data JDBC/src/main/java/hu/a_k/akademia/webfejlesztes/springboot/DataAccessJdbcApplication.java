package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.domain.entity.Car;
import hu.a_k.akademia.webfejlesztes.springboot.repository.api.CarRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

public class DataAccessJdbcApplication {

    public static void main(final String[] args) {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        final CarRepository carRepository = context.getBean("carRepositoryImpl", CarRepository.class);

        carRepository.save(Car
                .builder()
                .withBrand("Fiat")
                .withModel("Doblo")
                .withFuelType("Benzin")
                .withManufacturingDate(new Date(System.currentTimeMillis()))
                .withColor("Blue").build());

        carRepository.findByRegID(1).ifPresent(System.out::println);

        Car fiat_tipo = Car
                .builder()
                .withBrand("Fiat")
                .withModel("Tipo")
                .withFuelType("Diesel")
                .withManufacturingDate(new Date(System.currentTimeMillis()))
                .withColor("Black").build();

        carRepository.save(fiat_tipo);

        carRepository.setColor(2, "white");

        carRepository.delete(1);
    }

}

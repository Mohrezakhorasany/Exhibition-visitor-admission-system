package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.domain.entity.Car;
import hu.a_k.akademia.webfejlesztes.springboot.repository.api.CarRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.util.Calendar;

public class DataAccessJdbcApplication {

    public static void main(final String[] args) {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        final CarRepository carRepository = context.getBean("carRepositoryImpl", CarRepository.class);

        carRepository.save(Car
                .builder()
                .withBrand("Fiat")
                .withModel("Doblo")
                .withFuel_type("Benzin")
                .withManufacturing_date(new Date(Calendar.getInstance().getTime().getTime()))
                .withColor("Blue").build());

        carRepository.findByRegID(1).ifPresent(System.out::println);

        Car fiat_tipo = Car
                .builder()
                .withBrand("Fiat")
                .withModel("Tipo")
                .withFuel_type("Diesel")
                .withManufacturing_date(new Date(Calendar.getInstance().getTime().getTime()))
                .withColor("Black").build();

        carRepository.save(fiat_tipo);

        carRepository.setColor(2, "white");

        carRepository.delete(1);
    }

}

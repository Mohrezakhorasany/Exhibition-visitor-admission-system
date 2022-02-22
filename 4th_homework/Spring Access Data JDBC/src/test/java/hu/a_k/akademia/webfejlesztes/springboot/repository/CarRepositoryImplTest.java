package hu.a_k.akademia.webfejlesztes.springboot.repository;

import hu.a_k.akademia.webfejlesztes.springboot.domain.entity.Car;
import hu.a_k.akademia.webfejlesztes.springboot.domain.exception.EntityAlreadyExistsException;
import hu.a_k.akademia.webfejlesztes.springboot.repository.api.CarRepository;
import org.assertj.core.api.Assertions;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.sql.Date;
import java.time.LocalDate;

class CarRepositoryImplTest {

    private EmbeddedDatabase embeddedDatabase;
    private CarRepository objectUnderTest;
    private final Date currentDate = Date.valueOf(LocalDate.now());


    @BeforeEach
    void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder().addScript("/db/initial.sql")
                .setType(EmbeddedDatabaseType.H2)
                .build();
        objectUnderTest = new CarRepositoryImpl(new NamedParameterJdbcTemplate(embeddedDatabase),
                new SimpleJdbcInsert(embeddedDatabase)
                        .withSchemaName("factory")
                        .withTableName("car")
                        .usingGeneratedKeyColumns("registration_id"));

    }

    @AfterEach
    void tearDown() {
        embeddedDatabase.shutdown();
    }

    @Test
    void shouldInsertCar_whenSaveCar() {
        objectUnderTest.save(Car.builder()
                .withBrand("BMW")
                .withModel("i4")
                .withFuelType("Benzine")
                .withManufacturingDate(currentDate)
                .withColor("White")
                .build());

        Assertions.assertThat(objectUnderTest.findByRegID(1))
                .hasValueSatisfying(car -> {
                    Assertions.assertThat(car.getBrand()).isEqualTo("BMW");
                    Assertions.assertThat(car.getModel()).isEqualTo("i4");
                    Assertions.assertThat(car.getFuelType()).isEqualTo("Benzine");
                    Assertions.assertThat(car.getManufacturingDate()).isEqualTo(currentDate);
                    Assertions.assertThat(car.getColor()).isEqualTo("White");
                });
    }

    @Test
    void shouldThrowEntityAlreadyExistsException_whenSaveTwoCarsWithSameBrandModel() {
        objectUnderTest.save(Car.builder()
                .withRegistrationId(3)
                .withBrand("BMW")
                .withModel("i4")
                .withFuelType("Benzine")
                .withManufacturingDate(currentDate)
                .withColor("White")
                .build());

        Assertions.assertThatThrownBy(() -> objectUnderTest.save(
                        Car.builder()
                                .withRegistrationId(3)
                                .withBrand("BMW")
                                .withModel("i4")
                                .withFuelType("Benzine")
                                .withManufacturingDate(currentDate)
                                .withColor("White")
                                .build()))
                .hasMessage("Car already exits")
                .isExactlyInstanceOf(EntityAlreadyExistsException.class)
                .hasCauseExactlyInstanceOf(DuplicateKeyException.class)
                .hasRootCauseExactlyInstanceOf(JdbcSQLIntegrityConstraintViolationException.class);
    }
}
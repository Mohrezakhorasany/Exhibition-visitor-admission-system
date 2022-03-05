package hu.ak_akademia.spring_boot_rest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@Data
@SpringBootApplication(scanBasePackages = {
        "hu.ak_akademia.spring_boot_rest.controller",
        "hu.ak_akademia.spring_boot_rest.service",
        "hu.ak_akademia.spring_boot_rest.repository",
        "hu.ak_akademia.spring_boot_rest.aspects"
})
@EnableSwagger2

public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket docket(@Value("${application.name}") final String name,
                         @Value("${application.version}") final String version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().version(version)
                        .title(name)
                        .build())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("hu.ak_akademia.spring_boot_rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Animal Controller", "Animal Controller"));
    }

    @Bean
    public SimpleJdbcInsert simpleJdbcInsertAnimal(final DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource)
                .withSchemaName("zoo")
                .withTableName("animal")
                .usingGeneratedKeyColumns("animal_id");
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}

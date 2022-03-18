package com.m.reza.khorasany.participant;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Data
@SpringBootApplication(scanBasePackages = {
        "com.m.reza.khorasany.participant.controller",
        "com.m.reza.khorasany.participant.service",
        "com.m.reza.khorasany.participant.repository",
        "com.m.reza.khorasany.participant.aspects"
})
@EnableSwagger2
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.m.reza.khorasany.participant.controller"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Participant Controller", "Participant Controller"));
    }


}

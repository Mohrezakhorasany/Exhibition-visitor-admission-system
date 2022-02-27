package hu.ak.academy.spring.spring_boot.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/cars")
@RestController
public interface CarController {
    String getMapping();

    String postMapping();

    String putMapping();

    String patchMapping();

    String deleteMapping();
}

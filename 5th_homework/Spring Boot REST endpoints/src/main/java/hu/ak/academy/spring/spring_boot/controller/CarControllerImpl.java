package hu.ak.academy.spring.spring_boot.controller;

import hu.ak.academy.spring.spring_boot.controller.api.CarController;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/cars")
@RestController
public class CarControllerImpl implements CarController {

    @GetMapping
    @Override
    public String getMapping() {
        return "This is get mapping method.";
    }

    @PostMapping
    @Override
    public String postMapping() {
        return "This is post mapping method.";
    }

    @PutMapping
    @Override
    public String putMapping() {
        return "This is put mapping method.";
    }

    @PatchMapping
    @Override
    public String patchMapping() {
        return "This is patch mapping method.";
    }

    @DeleteMapping
    @Override
    public String deleteMapping() {
        return "This is delete mapping method.";
    }

}

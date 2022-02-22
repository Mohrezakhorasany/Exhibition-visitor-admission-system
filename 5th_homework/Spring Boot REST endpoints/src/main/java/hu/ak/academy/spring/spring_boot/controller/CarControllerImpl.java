package hu.ak.academy.spring.spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cars")
public class CarControllerImpl implements hu.ak.academy.spring.spring_boot.controller.api.CarController {

    @Override
    public String getMapping() {
        return "This is get mapping method.";
    }

    @Override
    public String postMapping() {
        return "This is post mapping method.";
    }

    @Override
    public String putMapping() {
        return "This is put mapping method.";
    }

    @Override
    public String patchMapping() {
        return "This is patch mapping method.";
    }

    @Override
    public String deleteMapping() {
        return "This is delete mapping method.";
    }

}

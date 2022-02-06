package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.api.ManagerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    final ManagerService managerService = context.getBean("managerServiceImpl", ManagerService.class);
        managerService.findingManagerBelowGivenAge(40).forEach(System.out::println);

    }




}

package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.life_cycle_management_demo.LifeCycleManagementDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        LifeCycleManagementDemo bean = context.getBean(LifeCycleManagementDemo.class);
        System.out.println(bean);
        context.close();

    }




}

package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.dal.AutoWireClientDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        AutoWireClientDemo autowireClient = context.getBean("autowireClient", AutoWireClientDemo.class);
        System.err.println(autowireClient);
        AutoWireClientDemo autowireClient1 = context.getBean("autowireClient", AutoWireClientDemo.class);
        System.out.println(autowireClient1);
    }




}

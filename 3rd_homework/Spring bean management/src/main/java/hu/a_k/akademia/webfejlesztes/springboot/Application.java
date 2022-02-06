package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.prototype.PrototypeDemo;
import hu.a_k.akademia.webfejlesztes.springboot.singelton.SingeltonDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SingeltonDemo singeltonDemo = context.getBean("singeltonDemo", SingeltonDemo.class);
        System.out.println(singeltonDemo);
        System.out.println(singeltonDemo);

       SingeltonDemo singeltonDemo1 = context.getBean("singeltonDemo", SingeltonDemo.class);
        System.out.println(singeltonDemo1);
        System.out.println(singeltonDemo1);


        PrototypeDemo prototypeDemo = context.getBean("prototypeDemo", PrototypeDemo.class);
        System.out.println(prototypeDemo);
        System.out.println(prototypeDemo);

        PrototypeDemo prototypeDemo2 = context.getBean("prototypeDemo", PrototypeDemo.class);
        System.out.println(prototypeDemo2);
        System.out.println(prototypeDemo2);

    }




}

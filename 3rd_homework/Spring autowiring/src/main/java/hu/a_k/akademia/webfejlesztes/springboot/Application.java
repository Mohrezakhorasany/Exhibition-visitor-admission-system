package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.service.util.MessageUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        final MessageUtils messageUtil = context.getBean("messageUtils", MessageUtils.class);
        System.out.println(messageUtil.getSuccessMsg().getMsg());
        System.out.println(messageUtil.getErrorMsg().getMsg());
    }


}

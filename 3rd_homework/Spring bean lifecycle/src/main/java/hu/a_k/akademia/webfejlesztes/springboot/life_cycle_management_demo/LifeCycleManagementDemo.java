package hu.a_k.akademia.webfejlesztes.springboot.life_cycle_management_demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalTime;

public class LifeCycleManagementDemo implements InitializingBean, DisposableBean {
    public LifeCycleManagementDemo() {
        System.out.println("Instantiation " + LocalTime.now());
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct " + LocalTime.now());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean  " + LocalTime.now());
    }

    public void init(){
        System.out.println("init Method  " + LocalTime.now());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy " + LocalTime.now());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy  " + LocalTime.now());
    }

    public void destroyMethod() {
        System.out.println(" Destroy method " + LocalTime.now());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize " + LocalTime.now());
    }
}

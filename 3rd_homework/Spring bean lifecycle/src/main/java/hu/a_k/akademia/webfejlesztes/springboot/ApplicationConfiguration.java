package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.life_cycle_management_demo.LifeCycleManagementDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hu.a_k.akademia.webfejlesztes.springboot")
public class ApplicationConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public LifeCycleManagementDemo lifeCycleManagementDemo(){
        return new LifeCycleManagementDemo();
    }


}

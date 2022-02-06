package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.dal.AutoWireClientDemo;
import hu.a_k.akademia.webfejlesztes.springboot.service.AutowireServiceDemo;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hu.a_k.akademia.webfejlesztes.springboot")
public class ApplicationConfiguration {

    @Bean("autowireServiceDemo")
    public AutowireServiceDemo getAutowireService() {
        return new AutowireServiceDemo();
    }

    @Bean(name = "autowireClient")
    public AutoWireClientDemo getAutowireClientByName(){
        return new AutoWireClientDemo();
    }

    @Bean(autowire =  Autowire.BY_TYPE)
    public AutoWireClientDemo getAutowireClientByType(){
        return new AutoWireClientDemo();
    }
}

package hu.a_k.akademia.webfejlesztes.springboot.dal;

import hu.a_k.akademia.webfejlesztes.springboot.service.AutowireServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutoWireClientDemo {


    private AutowireServiceDemo autowireServiceDemo;

    @Autowired
    @Qualifier("autowireServiceDemo")
    public void setAutowireServiceDemo(AutowireServiceDemo autowireServiceDemo) {
        this.autowireServiceDemo = autowireServiceDemo;
    }

    @Override
    public String toString() {
        return  autowireServiceDemo.toString();
    }
}

package hu.a_k.akademia.webfejlesztes.springboot.dal;

import hu.a_k.akademia.webfejlesztes.springboot.dal.api.ManagerRepository;
import hu.a_k.akademia.webfejlesztes.springboot.domain.Manager;

import java.util.List;


public class ManagerRepositoryImpl implements ManagerRepository {

    @Override
    public List<Manager> getAllManagers(){
        return List.of(new Manager("John", 35), new Manager("Jim", 45), new Manager("Jack", 50));
    }
}

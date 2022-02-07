package hu.a_k.akademia.webfejlesztes.springboot.service;

import hu.a_k.akademia.webfejlesztes.springboot.api.ManagerService;
import hu.a_k.akademia.webfejlesztes.springboot.dal.ManagerRepositoryImpl;
import hu.a_k.akademia.webfejlesztes.springboot.domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepositoryImpl managerRepository;

    @Override
    public List<Manager> findingManagerBelowGivenAge(int given) {
        return managerRepository.getAllManagers().stream().filter(manager -> manager.getAge() < given).toList();
    }
}

package hu.a_k.akademia.webfejlesztes.springboot.service;

import hu.a_k.akademia.webfejlesztes.springboot.dal.ManagerRepositoryImpl;
import hu.a_k.akademia.webfejlesztes.springboot.domain.Manager;
import hu.a_k.akademia.webfejlesztes.springboot.service.api.ManagerService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepositoryImpl managerRepository;

    @Override
    public List<Manager> findingManagerBelowGivenAge(int given) {
        return managerRepository.getAllManagers().stream().filter(manager -> manager.getAge() < given).toList();
    }
}

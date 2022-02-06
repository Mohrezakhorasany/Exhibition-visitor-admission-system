package hu.a_k.akademia.webfejlesztes.springboot.api;

import hu.a_k.akademia.webfejlesztes.springboot.domain.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> findingManagerBelowGivenAge(int given);
}

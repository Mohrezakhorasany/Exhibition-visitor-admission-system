package hu.a_k.akademia.webfejlesztes.springboot.dal.api;

import hu.a_k.akademia.webfejlesztes.springboot.domain.Manager;

import java.util.List;

public interface ManagerRepository {
    List<Manager> getAllManagers();
}

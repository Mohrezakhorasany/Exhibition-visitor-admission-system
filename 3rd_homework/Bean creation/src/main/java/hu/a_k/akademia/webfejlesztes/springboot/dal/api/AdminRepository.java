package hu.a_k.akademia.webfejlesztes.springboot.dal.api;

import hu.a_k.akademia.webfejlesztes.springboot.domain.Admin;

import java.util.List;

public interface AdminRepository {

    List<Admin> getAllAdmins();
}

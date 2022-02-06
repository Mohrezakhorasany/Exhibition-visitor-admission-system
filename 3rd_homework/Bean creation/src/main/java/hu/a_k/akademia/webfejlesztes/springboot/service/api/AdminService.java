package hu.a_k.akademia.webfejlesztes.springboot.service.api;

import hu.a_k.akademia.webfejlesztes.springboot.domain.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
}

package hu.a_k.akademia.webfejlesztes.springboot.service;

import hu.a_k.akademia.webfejlesztes.springboot.dal.api.AdminRepository;
import hu.a_k.akademia.webfejlesztes.springboot.domain.Admin;
import hu.a_k.akademia.webfejlesztes.springboot.service.api.AdminService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins(){
        return  adminRepository.getAllAdmins();
    }
}

package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.api.AdminService;
import hu.a_k.akademia.webfejlesztes.springboot.api.ManagerService;
import hu.a_k.akademia.webfejlesztes.springboot.dal.AdminRepositoryImpl;
import hu.a_k.akademia.webfejlesztes.springboot.dal.ManagerRepository;
import hu.a_k.akademia.webfejlesztes.springboot.dal.api.AdminRepository;
import hu.a_k.akademia.webfejlesztes.springboot.service.AdminServiceImpl;
import hu.a_k.akademia.webfejlesztes.springboot.service.ManagerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hu.a_k.akademia.webfejlesztes.springboot")
public class ApplicationConfiguration {


    @Bean("adminRepo")
    public AdminRepository getAdminRepo() {
        AdminRepository adminRepository = new AdminRepositoryImpl();
        return adminRepository;
    }

    @Bean("adminService")
    public AdminService getAdminService() {
        AdminService adminService = new AdminServiceImpl(getAdminRepo());
        return adminService;
    }

    @Bean(name = "managerRepository")
    public hu.a_k.akademia.webfejlesztes.springboot.dal.api.ManagerRepository getManagerRepository() {
        return new ManagerRepository();
    }

    @Bean(name = "managerService")
    public ManagerService getManagerService() {
        final ManagerServiceImpl managerService = new ManagerServiceImpl();
        return managerService;
    }
}

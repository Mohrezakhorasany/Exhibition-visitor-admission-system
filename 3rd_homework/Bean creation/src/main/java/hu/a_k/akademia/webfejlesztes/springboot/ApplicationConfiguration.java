package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.dal.AdminRepositoryImpl;
import hu.a_k.akademia.webfejlesztes.springboot.dal.api.AdminRepository;
import hu.a_k.akademia.webfejlesztes.springboot.api.AdminService;
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

//    @Bean(name = "managerRepository")
//    public ManagerRepository getManagerRepository() {
//        return new ManagerRepositoryImpl();
//    }
//
//    @Bean(name = "managerService")
//    public ManagerService getManagerService() {
//        final ManagerServiceImpl managerService = new ManagerServiceImpl();
//        managerService.setManagerRepository(getManagerRepository());
//        return managerService;
//    }
}

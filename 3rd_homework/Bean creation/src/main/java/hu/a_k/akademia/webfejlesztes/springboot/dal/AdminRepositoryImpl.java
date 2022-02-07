package hu.a_k.akademia.webfejlesztes.springboot.dal;

import hu.a_k.akademia.webfejlesztes.springboot.dal.api.AdminRepository;
import hu.a_k.akademia.webfejlesztes.springboot.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public List<Admin> getAllAdmins() {
        return List.of(new Admin("Reza"), new Admin("Norbi"), new Admin("Zoli"));
    }
}

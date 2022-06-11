package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Roles;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class RoleService {


    private RoleRepo roleRepo;

    public List<Roles> getList(){
        return roleRepo.findAll();
    }
    public Roles save(Roles roles){
        return roleRepo.save(roles);
    }
    public Optional<Roles> findById(Long id){
        return roleRepo.findById(id);
    }
    public void delete(Long id){
        roleRepo.deleteById(id);
    }

}

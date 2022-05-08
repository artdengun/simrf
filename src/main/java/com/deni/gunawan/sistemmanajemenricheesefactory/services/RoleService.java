package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Role;
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

    public List<Role> getList(){
        return roleRepo.findAll();
    }
    public Role save(Role role){
        return roleRepo.save(role);
    }
    public Optional<Role> findById(String id){
        return roleRepo.findById(id);
    }
    public void delete(String id){
        roleRepo.deleteById(id);
    }

}

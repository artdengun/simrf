package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.UserRoles;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRoleRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserRoleService {

    private UserRoleRepo usersRepo;

    public List<UserRoles> findAll(){return usersRepo.findAll();}
    public UserRoles save(UserRoles users){return usersRepo.save(users);}
    public Optional<UserRoles> findUsersById(String id){return usersRepo.findById(id);}
    public void delete(String id) {usersRepo.deleteById(id);}

}

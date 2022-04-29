package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author denigunawan
 */

@Service
@Slf4j
@AllArgsConstructor
public class UsersService {
    
    private UsersRepo usersRepo;
    
    public List<Users> findAll(){return usersRepo.findAll();}
    public Users save(Users users){return usersRepo.save(users);}
    private Optional<Users> findById(String id){return usersRepo.findById(id);}
    public void delete(String id) {
        usersRepo.deleteById(id);}



}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author denigunawan
 */

@Service
@Data
@AllArgsConstructor
@Transactional
public class UsersService {

    UsersRepo usersRepo;

    public List<Users> findAllUsers(){return usersRepo.findAll();}
    public void deleteUsers(String id){usersRepo.deleteById(id);}
    public Users savedUsers(Users users){return usersRepo.save(users);}
    public Optional<Users> saved(String id) { return usersRepo.findById(id);}

}

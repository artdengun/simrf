package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.User;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private UserRepo userRepo;

    public List<User> getList(){return userRepo.findAll();}
    public User save(User user){
        return userRepo.save(user);
    }
    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }
    public void delete(Long id){
        userRepo.deleteById(id);
    }

}

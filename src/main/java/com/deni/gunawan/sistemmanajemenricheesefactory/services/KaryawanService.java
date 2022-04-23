package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.KaryawanRepo;
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
public class KaryawanService {
    
    private KaryawanRepo karyawanRepo;
    
    public List<Users> findAll(){return karyawanRepo.findAll();}
    public Users save(Users users){return karyawanRepo.save(users);}
    private Optional<Users> findById(String id){return karyawanRepo.findById(id);}
    public void delete(String id) {karyawanRepo.deleteById(id);}



}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Karyawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.KaryawanRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class KaryawanService {
    
    private KaryawanRepo karyawanRepo;
    
    public List<Karyawan> getList(){
        try {
            karyawanRepo.findAll();
            log.info("SUCCESS GET ALL DATA");
        }catch (Exception e){
            log.info("ERROR List : ", e);
        }
        return null;
    }

    public Optional<Karyawan> findDataById(String id){
        try {
            karyawanRepo.findById(id);
            log.info("SUCCESS FIND DATA ");
        }catch (Exception e){
            log.info("ERROR FIND DATA: ", e);
        }
        return Optional.empty();
    }

    @Transactional
    public Karyawan saved(Karyawan karyawan){
        try {
            karyawanRepo.save(karyawan);
            log.info("SUCCESS SAVE DATA");
        }catch (Exception e){
            log.info("ERROR SAVED :  ", e);
        }
        return null;
    }

    @Transactional
    public void delete(String id){
        try {
            karyawanRepo.deleteById(id);
            log.info("SUCCESS DELETE DATA");
        }catch (Exception e){
            log.info("ERROR DELETE : ", e);
        }
    }
}

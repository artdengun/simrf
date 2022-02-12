package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataKaryawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataKaryawanRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class DataKaryawanService {
    
    private DataKaryawanRepo repo;

    public List<DataKaryawan> getData(){
        try {
            log.info("SUCCESS GET DATA");
            repo.findAll();
        }catch (Exception e){
            e.getCause();
            log.info("FAILED GET ALL DATA : [{}]", e.getMessage());
        }
        return null;
    }

    public Optional<DataKaryawan> getDataById(String id){
        try {
            log.info("SUCCESS FIND DATA BY ID");
            repo.findById(id);
        }catch (Exception e){
            e.getCause();
            log.info("FAILED GET DATA BY ID: [{}]", e.getMessage());

        }
        return Optional.empty();
    }

    @Transactional
    public DataKaryawan saved(DataKaryawan DataKaryawan){
        try {
            log.info("SUCCES SAVED");
            repo.save(DataKaryawan);
        }catch (Exception e){
            e.getCause();
            log.info("FAILED SAVE DATA: [{}]", e.getMessage());

        }
        return  null;
    }


    @Transactional
    public void deleteByAssets(String id){
        try {
            log.info("SUCCESS DELETE DATA");
            repo.deleteById(id);
        }catch (Exception e){
            e.getCause();
            log.info("FAILED DELETE DATA: [{}]", e.getMessage());
        }
    }
    
}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangFrozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangFrozenRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DataBarangFrozenService {

    private DataBarangFrozenRepo repo;
    
    public List<DataBarangFrozen> getData(){
        try {
            log.info("SUCCESS GET DATA");
            repo.findAll();
        }catch (Exception e){
            e.getCause();
            log.info("FAILED GET ALL DATA : [{}]", e.getMessage());
        }
        return null;
    }

    public Optional<DataBarangFrozen> getDataById(String id){
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
    public DataBarangFrozen saved(DataBarangFrozen DataBarangFrozen){
        try {
            log.info("SUCCES SAVED");
            repo.save(DataBarangFrozen);
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

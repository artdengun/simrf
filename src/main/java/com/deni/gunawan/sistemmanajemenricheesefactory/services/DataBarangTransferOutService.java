package com.deni.gunawan.sistemmanajemenricheesefactory.services;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangTransferOut;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangTransferOutRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DataBarangTransferOutService {
    
    private DataBarangTransferOutRepo repo;

    public List<DataBarangTransferOut> getData(){
        try {
            log.info("SUCCESS GET DATA");
            repo.findAll();
        }catch (Exception e){
            e.getCause();
            log.info("FAILED GET ALL DATA : [{}]", e.getMessage());
        }
        return null;
    }

    public Optional<DataBarangTransferOut> getDataById(String id){
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
    public DataBarangTransferOut saved(DataBarangTransferOut DataBarangTransferOut){
        try {
            log.info("SUCCES SAVED");
            repo.save(DataBarangTransferOut);
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

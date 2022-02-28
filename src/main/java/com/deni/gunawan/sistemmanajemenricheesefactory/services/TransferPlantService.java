package com.deni.gunawan.sistemmanajemenricheesefactory.services;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.TransferPlantRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TransferPlantService {

    private TransferPlantRepo transferPlantRepo;

    public Optional<TransferPlant> findDataById(String id){
        try {
            transferPlantRepo.findById(id);
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return Optional.empty();
    }

    public List<TransferPlant> getList(){
        try {
            transferPlantRepo.findAll();
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return null;
    }

    @Transactional
    public void delete(String id){
        try {
        transferPlantRepo.deleteById(id);
        }catch (Exception e){
            log.error("ERROR DELETE :  ", e);
        }
    }

    @Transactional
    public TransferPlant saved(TransferPlant transferPlant){
        try {
        transferPlantRepo.save(transferPlant);
        }catch (Exception e){
            log.error("ERROR SAVED :  ", e);
        }
        return null;
    }


}

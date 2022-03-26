package com.deni.gunawan.sistemmanajemenricheesefactory.services;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.TransferPlantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author denigunawan
 */

@Service
@AllArgsConstructor
@Transactional
public class TransferPlantService {

    private TransferPlantRepo transferPlantRepo;

    public List<TransferPlant> getList(){
        return transferPlantRepo.findAll();
    }
    public TransferPlant save(TransferPlant transferPlant){
        return transferPlantRepo.save(transferPlant);
    }
    public Optional<TransferPlant> findById(String id){
        return transferPlantRepo.findById(id);
    }
    public void delete(String id){
        transferPlantRepo.deleteById(id);
    }
}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangPenempatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangPenempatanRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DataBarangPenempatanService {
    
    private DataBarangPenempatanRepo repo;

    public List<DataBarangPenempatan> getData(){
        try {
            log.info("SUCCESS FIND ALL DATA");
            repo.findAll();
        }catch (Exception e){
            log.error("CAUSE : [{}]",e.getCause());
            log.error("FAILED FIND ALL DATA : [{}]",e.getMessage());
        }
        return null;
    }

    public Optional<DataBarangPenempatan> getDataById(String id){
        try {
            log.info("SUCCESS FIND DATA BY ID ");
            repo.findById(id);
        }catch (Exception e){
            log.error("CAUSE : [{}]",e.getCause());
            log.error("FAILED FIND BY ID : [{}]",e.getMessage());
        }
        return Optional.empty();
    }

    @Transactional
    public DataBarangPenempatan saved(DataBarangPenempatan DataBarangPenempatan){
        try {
            log.info("SUCCESS SAVED DATA");
            repo.save(DataBarangPenempatan);
        }catch (Exception e){
            log.error("CAUSE : [{}]",e.getCause());
            log.error("FAILED SAVE DATA : [{}]",e.getMessage());

        }
        return  null;
    }

    @Transactional
    public void deleteByAssets(String id){
        try {
            log.info("SUCCESS DELETE DATA");
            repo.deleteById(id);
        }catch (Exception e){
            log.error("CAUSE : [{}]",e.getCause());
            log.error("FAILED DELETE DATA : [{}]",e.getMessage());
        }
    }
    
}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangAsset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangAssetRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DataBarangAssetService {


    private DataBarangAssetRepo repo;

    public List<DataBarangAsset> getData(){
        try {
            log.info("SUCCESS GET DATA");
            repo.findAll();
        }catch (Exception e){
          log.error("CAUSE: [{}]", e.getCause());
          log.error("FAILED GET ALL DATA : [{}]", e.getMessage());
        }
        return null;
    }

    public Optional<DataBarangAsset> getDataById(String id){
      try {
          log.info("SUCCESS FIND DATA BY ID");
          repo.findById(id);
      }catch (Exception e){
          log.error("CAUSE: [{}]", e.getCause());
          log.error("FAILED GET DATA BY ID: [{}]", e.getMessage());

      }
      return Optional.empty();
    }

    @Transactional
    public DataBarangAsset saved(DataBarangAsset dataBarangAsset){
        try {
            log.info("SUCCES SAVED");
            repo.save(dataBarangAsset);
        }catch (Exception e){
          log.error("CAUSE: [{}]", e.getCause());
          log.error("FAILED SAVE DATA: [{}]", e.getMessage());

        }
        return  null;
    }

    @Transactional
    public void deleteByAssets(String id){
        try {
            log.info("SUCCESS DELETE DATA");
            repo.deleteById(id);
        }catch (Exception e){
            log.error("CAUSE: [{}]",e.getCause());
            log.error("FAILED DELETE DATA: [{}]", e.getMessage());
        }
    }
}

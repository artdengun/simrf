package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AssetService {

    private AssetRepo assetRepo;

    public List<Asset> getList(){
        try {
            assetRepo.findAll();
        }catch (Exception e){
            log.error("ERROR GET LIST :  ", e);
        }
        return null;
    }

    @Transactional
    public Asset saved(Asset asset){
        try {
            assetRepo.save(asset);
        }catch (Exception e){
            log.error("ERROR SAVE :  ", e);
        }
        return null;
    }


    public Optional<Asset> findDataById(String id){
        try {
        assetRepo.findById(id);
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return Optional.empty();
    }

    @Transactional
    public void delete(String id){
        try {
            assetRepo.deleteById(id);
        }catch (Exception e){
            log.error("ERROR DELETE :  ", e);
        }
    }
}

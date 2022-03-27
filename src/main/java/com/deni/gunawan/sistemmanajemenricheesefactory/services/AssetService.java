package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author denigunawan
 */

@Transactional
@Service
@AllArgsConstructor
public class AssetService {

    private AssetRepo assetRepo;

    public List<Asset> getList(){
        return assetRepo.findAll();
    }
    public Asset saved(Asset asset){
     return assetRepo.save(asset);
    }
    public Asset update(Asset asset){return assetRepo.save(asset);}
    public Optional<Asset> findDataById(String id){
        return assetRepo.findById(id);
    }
    public void delete(String id){
       assetRepo.deleteById(id);
    }
}

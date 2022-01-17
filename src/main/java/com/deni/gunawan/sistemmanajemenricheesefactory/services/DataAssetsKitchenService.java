package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataAssetsKitchen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataAssetsKitchenRepository;

@Service
public class DataAssetsKitchenService {
    
    @Autowired
    private DataAssetsKitchenRepository repo;

    public List<DataAssetsKitchen> getAllKitchen(){
        return repo.findAll();
    }

    @Transactional
    public DataAssetsKitchen savedKitchen(DataAssetsKitchen dataAssetsKitchen){
        return repo.save(dataAssetsKitchen);
    }

    public Optional<DataAssetsKitchen> findKitchenById(String id){
        return repo.findById(id);
    }
    
    @Transactional
    public void deleteAssetKitchen(String id){
        this.repo.deleteById(id);
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangKitchen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangKitchenRepo;

@Service
public class DataKitchenService {
    
    @Autowired
    private DataBarangKitchenRepo repo;

    public List<DataBarangKitchen> getAllKitchen(){
        return repo.findAll();
    }

    @Transactional
    public DataBarangKitchen savedKitchen(DataBarangKitchen dataBarangKitchen){
        return repo.save(dataBarangKitchen);
    }

    public Optional<DataBarangKitchen> findKitchenById(String id){
        return repo.findById(id);
    }
    
    @Transactional
    public void deleteAssetKitchen(String id){
        this.repo.deleteById(id);
    }

}

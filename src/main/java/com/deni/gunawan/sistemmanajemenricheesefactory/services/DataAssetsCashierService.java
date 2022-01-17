package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataAssetsCashier;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataAssetsCashierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DataAssetsCashierService {

    @Autowired
    private DataAssetsCashierRepository repo;

    public List<DataAssetsCashier> getDataCashier(){
        return repo.findAll();
    }

    @Transactional
    public DataAssetsCashier saved(DataAssetsCashier dataAssetsCashier){
        return repo.save(dataAssetsCashier);
    }

    public Optional<DataAssetsCashier> findDataCashier(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteCashier(String id){
        this.repo.deleteById(id);
    }
}

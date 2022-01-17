package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataAssetsManager;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataAssetsManagerRepository;

@Service
public class DataAssetsManagerService {

    @Autowired
    private DataAssetsManagerRepository repo;

    private List<DataAssetsManager> getListAssetManager(){
        return repo.findAll();
    }

    private Optional<DataAssetsManager> findAssetById(String id){
        return repo.findById(id);
    }

    @Transactional
    private DataAssetsManager saved(DataAssetsManager dataAssetsManager){
        return repo.save(dataAssetsManager);
    }

    @Transactional
    private void deleteManager(String id){
        this.repo.deleteById(id);
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangManager;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangManagerRepo;

@Service
public class DataManagerService {

    @Autowired
    private DataBarangManagerRepo repo;

    private List<DataBarangManager> getListAssetManager(){
        return repo.findAll();
    }

    private Optional<DataBarangManager> findAssetById(String id){
        return repo.findById(id);
    }

    @Transactional
    private DataBarangManager saved(DataBarangManager dataAssetsManager){
        return repo.save(dataAssetsManager);
    }

    @Transactional
    private void deleteManager(String id){
        this.repo.deleteById(id);
    }

}

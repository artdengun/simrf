package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangAyam;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangAyamRepo;

@Service
public class DataBarangAyamService {


    @Autowired
    private DataBarangAyamRepo repo;


    @Transactional
    public DataBarangAyam saved(DataBarangAyam dataBarangAyam){
        return repo.save(dataBarangAyam);
    }

    @Transactional
    public void deleteBarangAyam(String id){
        this.repo.deleteById(id);
    }

    public List<DataBarangAyam> getListBarangAyam(){
        return repo.findAll();
    }

    public Optional<DataBarangAyam> getDataAyamById(String id){
        return repo.findById(id);
    }

}

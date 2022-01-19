package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangRetur;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangReturRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DataBarangReturService {

    @Autowired
    private DataBarangReturRepo repo;

    @Transactional
    public DataBarangRetur save(DataBarangRetur dataBarangRetur){
        return repo.save(dataBarangRetur);
    }

    public List<DataBarangRetur> listBarangRetur(){
        return repo.findAll();
    }

    public Optional<DataBarangRetur> findBarangReturById(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteBarangRetur(String id){
        this.repo.deleteById(id);
    }
}

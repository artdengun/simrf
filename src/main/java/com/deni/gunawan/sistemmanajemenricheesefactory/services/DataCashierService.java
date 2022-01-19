package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangCashier;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangCashierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DataCashierService {

    @Autowired
    private DataBarangCashierRepo repo;

    public List<DataBarangCashier> getDataCashier(){
        return repo.findAll();
    }

    @Transactional
    public DataBarangCashier saved(DataBarangCashier dataBarangCashier){
        return repo.save(dataBarangCashier);
    }

    public Optional<DataBarangCashier> findDataCashier(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteCashier(String id){
        this.repo.deleteById(id);
    }
}

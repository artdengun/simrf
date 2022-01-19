package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangMinyak;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangMinyakRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DataBarangMinyakService {

    @Autowired
    private DataBarangMinyakRepo repo;


    @Transactional
    public DataBarangMinyak save(DataBarangMinyak dataBarangMinyak){
        return repo.save(dataBarangMinyak);
    }

    public List<DataBarangMinyak> listDataBarangMinyak(){
        return repo.findAll();
    }

    public Optional<DataBarangMinyak> barangMinyakFindData(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteBarangMinyak(String id){
        this.repo.deleteById(id);
    }
}

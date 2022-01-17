package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataKaryawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataKaryawanRepository;

@Service
public class DataKaryawanService {

    @Autowired
    private DataKaryawanRepository repo;

    @Transactional
    public DataKaryawan save(DataKaryawan dataKaryawan){
        return repo.save(dataKaryawan);
    }

    public Optional<DataKaryawan> findByIdKaryawan(String id){
        return repo.findById(id);
    }

    public List<DataKaryawan> getListKaryawan(){
        return repo.findAll();
    }

    @Transactional
    public void deleteKaryawan(String id){
         this.repo.deleteById(id);
    }

}

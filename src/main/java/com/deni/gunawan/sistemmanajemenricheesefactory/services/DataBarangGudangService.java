package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangGudang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangGudangRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DataBarangGudangService {

        @Autowired
        private DataBarangGudangRepo repo;

        @Transactional
        public DataBarangGudang save(DataBarangGudang dataBarangGudang){
                return repo.save(dataBarangGudang);
        }

        public List<DataBarangGudang> getListBarangGudang(){
                return repo.findAll();
        }

        public Optional<DataBarangGudang> findBarangGudang(String id){
                return repo.findById(id);
        }

        @Transactional
        public void deleteDataBarang(String id){
                this.repo.deleteById(id);
        }
}

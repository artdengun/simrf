package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangPenempatan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangPenempatanRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DataBarangPenempatanService {
    
    private DataBarangPenempatanRepo repo;

    public List<DataBarangPenempatan> getData(){
        try {
            repo.findAll();
        }catch (Exception e){
            e.getCause();
            e.getMessage();
        }
        return null;
    }

    public Optional<DataBarangPenempatan> getDataById(String id){
        try {
            repo.findById(id);
        }catch (Exception e){
            e.getCause();
            e.getMessage();
        }
        return Optional.empty();
    }

    @Transactional
    public DataBarangPenempatan saved(DataBarangPenempatan DataBarangPenempatan){
        try {
            repo.save(DataBarangPenempatan);
        }catch (Exception e){
            e.getCause();
            e.getMessage();

        }
        return  null;
    }


    @Transactional
    public void deleteByAssets(String id){
        try {
            repo.deleteById(id);
        }catch (Exception e){
            e.getCause();
            e.getMessage();
        }
    }
    
}

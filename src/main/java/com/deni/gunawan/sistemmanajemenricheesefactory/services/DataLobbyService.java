package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataBarangLobby;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataBarangLobbyRepo;

@Service
public class DataLobbyService {

    @Autowired
    private DataBarangLobbyRepo repo;

    @Transactional
    public DataBarangLobby savedData(DataBarangLobby dataAssetsLobby){
        return repo.save(dataAssetsLobby);
    }

    public List<DataBarangLobby> findDataLobby(){
        return repo.findAll();
    }

    public Optional<DataBarangLobby> findByIdLobby(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteLobby(String id){
        this.repo.deleteById(id);
    }


}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataAssetsLobby;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.DataAssetsLobbyRepository;

@Service
public class DataAssetsLobbyService {

    @Autowired
    private DataAssetsLobbyRepository repo;

    @Transactional
    public DataAssetsLobby savedData(DataAssetsLobby dataAssetsLobby){
        return repo.save(dataAssetsLobby);
    }

    public List<DataAssetsLobby> findDataLobby(){
        return repo.findAll();
    }

    public Optional<DataAssetsLobby> findByIdLobby(String id){
        return repo.findById(id);
    }

    @Transactional
    public void deleteLobby(String id){
        this.repo.deleteById(id);
    }


}

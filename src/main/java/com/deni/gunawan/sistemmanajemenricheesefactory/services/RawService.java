package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RawRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RawService {

    private RawRepo rawRepo;


    public List<Raw> getList(){
        try {
        rawRepo.findAll();
        }catch (Exception e){
            log.error("ERROR GET LIST :  ", e);
        }
        return null;
    }


    public Optional<Raw> findDataById(String id){
        try {
        rawRepo.findById(id);
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return Optional.empty();
    }

    @Transactional
    public Raw saved(Raw raw){
        try {
        rawRepo.save(raw);
        }catch (Exception e){
            log.error("ERROR SAVED :  ", e);
        }
        return null;
    }

    @Transactional
    public void delete(String id){
        try {
        rawRepo.deleteById(id);
        }catch (Exception e){
            log.error("ERROR DELETE :  ", e);
        }
    }

}

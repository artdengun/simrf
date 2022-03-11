package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.ReturRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author denigunawan
 */

@Service
@AllArgsConstructor
@Slf4j
public class ReturService {

    private ReturRepo returRepo;


    public Optional<Retur> findDataById(String id){
        try {
        returRepo.findById(id);
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return Optional.empty();
    }

    public List<Retur> getList(){
        try {
        returRepo.findAll();
        }catch (Exception e){
            log.error("ERROR GET LIST :  ", e);
        }
        return null;
    }

    @Transactional
    public Retur saved(Retur retur){
        try {
        returRepo.save(retur);
        }catch (Exception e){
            log.error("ERROR GET LIST :  ", e);
        }
        return null;
    }

    @Transactional
    public void delete(String id){
        try {
        returRepo.deleteById(id);
        }catch (Exception e){
            log.error("ERROR DELETE :  ", e);
        }
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.FrozenRepo;
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
public class FrozenService {

    private FrozenRepo frozenRepo;

    public Optional<Frozen> findDataById(String id){
        try {
        frozenRepo.findById(id);
        }catch (Exception e){
            log.error("ERROR FIND DATA :  ", e);
        }
        return Optional.empty();
    }

    public List<Frozen> getList(){
        try {
        frozenRepo.findAll();
        }catch (Exception e){
            log.error("ERROR GET LIST :  ", e);
        }
        return  null;
    }

    @Transactional
    public void delete(String id){
        try {
        frozenRepo.deleteById(id);
        }catch (Exception e){
            log.error("ERROR DELETE :  ", e);
        }
    }

    @Transactional
    public Frozen saved(Frozen frozen){
        try {
        frozenRepo.save(frozen);
        }catch (Exception e){
            log.error("ERROR SAVED :  ", e);
        }
        return null;
    }
}

package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RawRepo;
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
@Transactional
public class RawService {

    private RawRepo rawRepo;

    public List<Raw> getList(){
        return rawRepo.findAll();
    }
    public Raw save(Raw raw){
        return rawRepo.save(raw);
    }
    public Optional<Raw> findById(String id){
        return rawRepo.findById(id);
    }
    public void delete(String id){
        rawRepo.deleteById(id);
    }

}

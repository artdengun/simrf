package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
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
@Transactional
public class ReturService {

    private ReturRepo returRepo;

    public List<Retur> getList(){
        return returRepo.findAll();
    }
    public Retur save(Retur retur){
        return returRepo.save(retur);
    }
    public Optional<Retur> findById(Long id){
        return returRepo.findById(id);
    }
    public void delete(Long id){
        returRepo.deleteById(id);
    }

}

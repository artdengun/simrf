package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.FrozenRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author denigunawan
 */
@Service
@AllArgsConstructor
public class FrozenService {

    private FrozenRepo frozenRepo;

    public List<Frozen> getList(){
        return frozenRepo.findAll();
    }
    @Transactional
    public Frozen save(Frozen frozen){
        return frozenRepo.save(frozen);
    }
    public Optional<Frozen> findById(String id){
        return frozenRepo.findById(id);
    }
    @Transactional
    public void delete(String id){
        frozenRepo.deleteById(id);
    }
}

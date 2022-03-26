package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Karyawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.KaryawanRepo;
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
@Slf4j
@AllArgsConstructor
public class KaryawanService {
    
    private KaryawanRepo karyawanRepo;
    
    public List<Karyawan> findAll(){return karyawanRepo.findAll();}
    public Karyawan save(Karyawan karyawan){return karyawanRepo.save(karyawan);}
    private Optional<Karyawan> findById(String id){return karyawanRepo.findById(id);}
    public void delete(String id) {karyawanRepo.deleteById(id);}



}

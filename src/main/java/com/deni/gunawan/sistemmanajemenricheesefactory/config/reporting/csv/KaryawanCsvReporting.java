package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author denigunawan
 */

@Service
@AllArgsConstructor
@Slf4j
public class KaryawanCsvReporting {


    private UsersRepo usersRepo;

    public void exportKaryawanAsCSV(Writer writer)throws IOException {
        List<Users> listUsers = usersRepo.findAll();
        try(CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)){
            for(Users users : listUsers){
                printer.printRecord(
                        users.getId(),
                        users.getAlamat(),
                        users.getJabatan(),
                        users.getNama(),
                        users.getJenisKelamin(),
                        users.getPendidikan(),
                        users.getStatusPerkawinan(),
                        users.getTanggalJoin(),
                        users.getTelephone()
                );
            }
        }catch (IOException e){
            e.getStackTrace();
            log.info("ERROR WHEN READ CSV : ", e);
        }
    }


}

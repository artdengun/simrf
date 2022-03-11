package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Karyawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.KaryawanRepo;
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


    private KaryawanRepo karyawanRepo;

    public void exportKaryawanAsCSV(Writer writer)throws IOException {
        List<Karyawan> listKaryawan = karyawanRepo.findAll();
        try(CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)){
            for(Karyawan karyawan : listKaryawan){
                printer.printRecord(
                        karyawan.getId(),
                        karyawan.getAlamat(),
                        karyawan.getJabatan(),
                        karyawan.getKtp(),
                        karyawan.getNama(),
                        karyawan.getJenisKelamin(),
                        karyawan.getPendidikan(),
                        karyawan.getStatusPerkawinan(),
                        karyawan.getTanggalJoin(),
                        karyawan.getTelephone()
                );
            }
        }catch (IOException e){
            e.getStackTrace();
            log.info("ERROR WHEN READ CSV : ", e);
        }
    }


}

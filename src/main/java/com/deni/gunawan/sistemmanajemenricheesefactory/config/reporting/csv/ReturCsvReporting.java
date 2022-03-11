package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.ReturRepo;
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
public class ReturCsvReporting {

    private ReturRepo repo;

    public void exportReturAsCSV(Writer writer){
        List<Retur> listRetur = repo.findAll();
        try(CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for(Retur retur : listRetur){
                printer.printRecord(
                        retur.getId(),
                        retur.getNamaBarang(),
                        retur.getJumlahRetur(),
                        retur.getTanggalRetur(),
                        retur.getDeskripsi(),
                        retur.getCodeBarang(),
                        retur.getExpDate(),
                        retur.getNegara(),
                        retur.getProductionDate(),
                        retur.getUom(),
                        retur.getVendor()
                );
            }
        }catch (IOException e){
            e.getStackTrace();
            log.info("ERROR WHEN READ DATA : ", e);
        }
    }

}

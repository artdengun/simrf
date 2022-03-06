package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RawRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RawCsvReporting {

    private RawRepo repo;

    public void exportRawAsCSV(Writer writer){
        List<Raw> listRaw = repo.findAll();
        try(CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for(Raw raw : listRaw){
                printer.printRecord(
                        raw.getId(),
                        raw.getCodeBarang(),
                        raw.getDeskripsi(),
                        raw.getExpDate(),
                        raw.getKaryawan(),
                        raw.getNamaProduct(),
                        raw.getNegara(),
                        raw.getProductionDate(),
                        raw.getTanggalPenerimaan(),
                        raw.getUom(),
                        raw.getVendor()
                );
            }
        }catch (IOException e){
            e.getStackTrace();
            log.info("ERROR WHEN READ CSV", e);
        }
    }

}

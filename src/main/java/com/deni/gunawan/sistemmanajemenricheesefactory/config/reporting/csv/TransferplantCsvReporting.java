package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.TransferPlantRepo;
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
public class TransferplantCsvReporting {

    private TransferPlantRepo repo;

    public void exportTransferPlantAsCSV(Writer writer) {
        List<TransferPlant> listTransferPlant = repo.findAll();
        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for(TransferPlant transferPlant : listTransferPlant){
                printer.printRecord(
                        transferPlant.getId(),
                        transferPlant.getKaryawan(),
                        transferPlant.getModIncharge(),
                        transferPlant.getNamaBarang(),
                        transferPlant.getNoDokumen(),
                        transferPlant.getOutletPenerima(),
                        transferPlant.getOutletPengirim(),
                        transferPlant.getQuantiyBarang(),
                        transferPlant.getTanggalDikirim(),
                        transferPlant.getUom()
                );
            }
        }catch (IOException e){
            e.getStackTrace();
            log.info("ERROR WEHEN READ DATA : ", e);
        }
    }

}

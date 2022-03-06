package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.FrozenRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FrozenCsvReporting {

    // 1. insialisasi repo
    private FrozenRepo frozenRepo;

    // 2. Implement method untuk menampung fungsi export csv
    public void createFrozenAsCSV(Writer writer) throws IOException{
        // 3. tampung datanya dalam list, kemudian ambil semua datanya
        List<Frozen> getListFrozen = frozenRepo.findAll();
        // panggil printer
        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)){
            // perulangan data agar datanya ditampilkan berdasarkan jumlahnya
            for(Frozen frozen : getListFrozen) {
                printer.printRecord(
                        // record print apa saja yang ingin dijadikan csv
                        frozen.getId(),
                        frozen.getCodeBarang(),
                        frozen.getDeskripsi(),
                        frozen.getKaryawan(),
                        frozen.getExpDate(),
                        frozen.getNamaProduct(),
                        frozen.getNegara(),
                        frozen.getProductionDate(),
                        frozen.getTanggalPenerimaan(),
                        frozen.getUom(),
                        frozen.getVendor()
                );
            }
        }catch (IOException e){
            log.info("ERROR WHEN READ CSV : ", e);
        }
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
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
public class AssetCsvReporting {

    private AssetRepo assetRepo;

    public void exportAssetAsCSV(Writer writer){
        List<Asset> listAsset = assetRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)){
            for(Asset assetLooping : listAsset){
                csvPrinter.printRecord(
                        assetLooping.getId(),
                        assetLooping.getHargaAssets(),
                        assetLooping.getNoAssets(),
                        assetLooping.getJenis(),
                        assetLooping.getNama(),
                        assetLooping.getQuantity(),
                        assetLooping.getTanggalDiterima(),
                        assetLooping.getTanggalInput(),
                        assetLooping.getVendor()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Error While Writing CSV: ", e);
        }
    }

}

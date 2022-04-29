package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AssetPdfReporting {

    private AssetRepo assetRepo;

    public JasperPrint exportPDF() throws FileNotFoundException, JRException {

        // LIST NYA TAMPILKAN
        List<Asset> assets  = assetRepo.findAll();

        // ambil file dan kompilasi filenya
        File file = ResourceUtils.getFile("classpath:reporting/asset.jrxml");

        // panggil fungsi untuk compile manager
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // ambil datanya dari db
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(assets);

        // map data

        Map<String, Object> data  = new HashMap<>();

        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data,dataSource);


        return jasperPrint;
    }



}

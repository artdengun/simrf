package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.TransferPlantRepo;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TransferplantPdfReporting {

    private TransferPlantRepo  transferPlantRepo;

    public JasperPrint exportPDF() throws FileNotFoundException, JRException {

        // LIST NYA TAMPILKAN
        List<TransferPlant> transferPlants  = transferPlantRepo.findAll();

        // ambil file dan kompilasi filenya
        File file = ResourceUtils.getFile("classpath:reporting/transferplant.jrxml");

        // panggil fungsi untuk compile manager
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // ambil datanya dari db
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transferPlants);

        // map data

        Map<String, Object> data  = new HashMap<>();

        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data,dataSource);


        return jasperPrint;
    }


}

package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.ReturRepo;
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
public class ReturPdfReporting {


    private ReturRepo returRepo;


    public JasperPrint exportPDF() throws FileNotFoundException, JRException {

        // LIST NYA TAMPILKAN
        List<Retur> retur  = returRepo.findAll();

        // ambil file dan kompilasi filenya
        File file = ResourceUtils.getFile("classpath:reporting/retur.jrxml");

        // panggil fungsi untuk compile manager
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // ambil datanya dari db
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(retur);

        // map data

        Map<String, Object> data  = new HashMap<>();

        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data,dataSource);


        return jasperPrint;
    }

}

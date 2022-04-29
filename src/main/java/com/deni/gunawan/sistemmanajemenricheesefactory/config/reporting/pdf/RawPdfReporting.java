package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RawRepo;
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
public class RawPdfReporting {

    private RawRepo rawRepo;

    public JasperPrint exportPDF() throws FileNotFoundException, JRException {

        // LIST NYA TAMPILKAN
        List<Raw> raws  = rawRepo.findAll();

        // ambil file dan kompilasi filenya
        File file = ResourceUtils.getFile("classpath:reporting/raw.jrxml");

        // panggil fungsi untuk compile manager
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // ambil datanya dari db
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(raws);

        // map data

        Map<String, Object> data  = new HashMap<>();

        // print report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data,dataSource);


        return jasperPrint;
    }
}

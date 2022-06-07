package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;


import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;

@Service
@AllArgsConstructor
public class PDFReporting {

    private DataSource dataSource;

    private Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public JasperPrint generateAssetReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/asset.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }

    public JasperPrint generateRawReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/raw.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }

    public JasperPrint generateFrozenReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/frozen.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }


    public JasperPrint generateReturReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/retur.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }


    public JasperPrint generateTransferPlantReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/transferplant.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }


    public JasperPrint generateUsersReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/users.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }
}

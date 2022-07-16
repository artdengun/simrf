package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class PDFReporting {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException {
            return dataSource.getConnection();
    }

    public JasperPrint generateAssetReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/asset.jasper")
                .getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        return JasperFillManager.fillReport(jasperReport, null, getConnection());

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
        return JasperFillManager.fillReport(jasperReport, null, getConnection());

    }


    public JasperPrint generateTransferPlantReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/transferplant.jasper").getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }

    public JasperPrint generateRoleReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/roles.jasper").getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }

    public JasperPrint generateUserReporting() throws Exception{
        InputStream fileReport = new ClassPathResource("reporting/user.jasper").getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, getConnection());
        return jasperPrint;

    }


}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers.reports.export;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.PDFReporting;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author denigunawan
 */

@Controller
@AllArgsConstructor
public class ExportPdfController {

        private PDFReporting pdfReporting;
        private HttpServletResponse httpServletResponse;


        @GetMapping(value = "/asset/export/pdf")
        public void getPDFAssetReport() throws Exception {
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-asset_" + currentDateTime +".pdf\"");
            JasperPrint jasperPrint = pdfReporting.generateAssetReporting();
            JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

        }

        @GetMapping(value = "/frozen/export/pdf")
        public void getPDFFrozenReport() throws Exception {
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-frozen_"+ currentDateTime +".pdf\"");
            JasperPrint jasperPrint = pdfReporting.generateFrozenReporting();
            JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }


        @GetMapping(value = "/raw/export/pdf")
        public void getPDFRawReport() throws Exception {
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-raw_"+currentDateTime+".pdf\"");
            JasperPrint jasperPrint = pdfReporting.generateRawReporting();
            JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }

    @GetMapping(value = "/retur/export/pdf")
    public void getPDFReturReport() throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-retur_"+currentDateTime+".pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateReturReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }


    @GetMapping(value = "/transferplant/export/pdf")
    public void getPDFTransferPlantReport() throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-transferplant_" +  currentDateTime +".pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateTransferPlantReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }


    @GetMapping(value = "/users/export/pdf")
    public void getPDFUsersReport() throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data-users_"+currentDateTime+".pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateUsersReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }



}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers.reports.export;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.PDFReporting;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;


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
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data_asset.pdf\"");
            JasperPrint jasperPrint = pdfReporting.generateAssetReporting();
            JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

        }

        @GetMapping(value = "/frozen/export/pdf")
        public void getPDFFrozenReport() throws Exception {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data_frozen.pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateFrozenReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }


        @GetMapping(value = "/raw/export/pdf")
        public void getPDFRawReport() throws Exception {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data_raw.pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateRawReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }

    @GetMapping(value = "/retur/export/pdf")
    public void getPDFReturReport() throws Exception {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data_retur.pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateReturReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }


    @GetMapping(value = "/transferplant/export/pdf")
    public void getPDFTransferPlantReport() throws Exception {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"data_transferplant.pdf\"");
        JasperPrint jasperPrint = pdfReporting.generateTransferPlantReporting();
        JasperExportManager.exportReportToPdfStream(jasperPrint,httpServletResponse.getOutputStream());

    }



}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers.reports.export;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.AssetPdfReporting;
import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.TransferplantPdfReporting;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.PDFService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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

        private PDFService pdfService;

    @GetMapping(value = "/transferplant/export/pdf")
    public void exportTransferplantPDF(HttpServletResponse response) throws IOException, JRException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_transferplant_"+currentDateTime+".pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.exportReportTransferPlant(outputStream);
    }


    @GetMapping(value = "/asset/export/pdf")
    public void exportAssetPDF(HttpServletResponse response) throws IOException, JRException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_asset_"+currentDateTime+".pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.exportReportAsset(outputStream);
    }


    @GetMapping(value = "/frozen/export/pdf")
    public void exportFrozenPDF(HttpServletResponse response) throws IOException, JRException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_frozen_"+currentDateTime+".pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.exportReportFrozen(outputStream);
    }


    @GetMapping(value = "/retur/export/pdf")
    public void exportReturPDF(HttpServletResponse response) throws IOException, JRException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_retur_"+currentDateTime+".pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.exportReportRetur(outputStream);
    }

    @GetMapping(value = "/raw/export/pdf")
    public void exportRawPDF(HttpServletResponse response) throws IOException, JRException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_raw_"+currentDateTime+".pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.exportReportRaw(outputStream);
    }

}

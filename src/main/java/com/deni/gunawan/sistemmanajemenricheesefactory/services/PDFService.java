package com.deni.gunawan.sistemmanajemenricheesefactory.services;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.*;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.OutputStream;

@Service
@AllArgsConstructor
public class PDFService {

    private TransferplantPdfReporting transferplantPdfReporting;
    private AssetPdfReporting assetPdfReporting;
    private ReturPdfReporting returPdfReporting;
    private RawPdfReporting rawPdfReporting;
    private FrozenPdfReporting frozenPdfReporting;

    public void exportReportTransferPlant(OutputStream outputStream) throws JRException, FileNotFoundException {
        JasperPrint jasperPrint = transferplantPdfReporting.exportPDF();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public void exportReportAsset(OutputStream outputStream) throws JRException, FileNotFoundException {
        JasperPrint jasperPrint = assetPdfReporting.exportPDF();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public void exportReportRaw(OutputStream outputStream) throws JRException, FileNotFoundException {
        JasperPrint jasperPrint = rawPdfReporting.exportPDF();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public void exportReportRetur(OutputStream outputStream) throws JRException, FileNotFoundException {
        JasperPrint jasperPrint = returPdfReporting.exportPDF();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

    public void exportReportFrozen(OutputStream outputStream) throws JRException, FileNotFoundException {
        JasperPrint jasperPrint = frozenPdfReporting.exportPDF();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}

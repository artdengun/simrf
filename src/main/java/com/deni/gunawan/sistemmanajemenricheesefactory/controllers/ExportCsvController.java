package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@Controller
@RequestMapping(value = "reporting/csv")
@AllArgsConstructor
public class ExportCsvController {

    private AssetCsvReporting assetCsvReporting;
    private KaryawanCsvReporting karyawanCsvReporting;
    private FrozenCsvReporting frozenCsvReporting;
    private ReturCsvReporting returCsvReporting;
    private RawCsvReporting rawCsvReporting;
    private TransferplantCsvReporting transferplantCsvReporting;

    @GetMapping(value = "/asset")
    public void exportAssetCSV(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"Employee.csv\"");
        assetCsvReporting.exportAssetAsCSV(httpServletResponse.getWriter());
    }

    @GetMapping(value = "/transferplant")
    public void exportTransferplantCSV(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"TransferPlant.csv\"");
        transferplantCsvReporting.exportTransferPlantAsCSV(httpServletResponse.getWriter());
    }

    @GetMapping(value = "/retur")
    public void exportReturCSV(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"Retur.csv\"");
        returCsvReporting.exportReturAsCSV(httpServletResponse.getWriter());
    }

    @GetMapping(value = "/raw")
    public void exportRawCSV(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"Raw.csv\"");
        rawCsvReporting.exportRawAsCSV(httpServletResponse.getWriter());
    }

    @GetMapping(value = "/frozen")
    public void exportFrozenCSV(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"Frozen.csv\"");
        frozenCsvReporting.createFrozenAsCSV(httpServletResponse.getWriter());
    }

    @GetMapping(value = "/karyawan")
    public void exportKaryawanCSV(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader("Content-Disposition","attachment: filename=\"Karyawan.csv\"");
        karyawanCsvReporting.exportKaryawanAsCSV(httpServletResponse.getWriter());
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers.reports.export;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel.*;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.*;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author denigunawan
 */

@Controller
@AllArgsConstructor
public class ExportExcelController {

    // excel port
    private AssetExcelReporting assetExcelReporting;
    private FrozenExcelReporting frozenExcelReporting;
    private RawExcelReporting rawExcelReporting;
    private ReturExcelReporting returExcelReporting;
    private TransferplantExcelReporting transferplantExcelReporting;
    private UsersExcelReporting usersExcelReporting;

    // REPO
    private AssetRepo assetRepo;
    private FrozenRepo frozenRepo;
    private RawRepo rawRepo;
    private ReturRepo returRepo;
    private TransferPlantRepo transferPlantRepo;
    private UsersRepo usersRepo;

    @GetMapping("/asset/export/excel")
    public void exportExcelAsset(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-asset_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Asset> listAssets = assetRepo.findAll();

        AssetExcelReporting excelExporter = new AssetExcelReporting(listAssets);

        excelExporter.export(response);
    }

    @GetMapping("/frozen/export/excel")
    public void exportExcelFrozen(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-frozen_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Frozen> listFrozen = frozenRepo.findAll();

        FrozenExcelReporting excelExporter = new FrozenExcelReporting(listFrozen);

        excelExporter.export(response);
    }

    @GetMapping("/raw/export/excel")
    public void exportExcelRaw(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-raw_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Raw> listRaw = rawRepo.findAll();

        RawExcelReporting excelExporter = new RawExcelReporting(listRaw);

        excelExporter.export(response);
    }

    @GetMapping("/retur/export/excel")
    public void exportExcelRetur(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-retur_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Retur> listRetur = returRepo.findAll();

        ReturExcelReporting returExcelReporting = new ReturExcelReporting(listRetur);

        returExcelReporting.export(response);
    }

    @GetMapping("/transferplant/export/excel")
    public void exportExcelTransferPlant(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-transferplant_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<TransferPlant> listTransferplant = transferPlantRepo.findAll();

        TransferplantExcelReporting excelExporter = new TransferplantExcelReporting(listTransferplant);

        excelExporter.export(response);
    }


    @GetMapping("/users/export/excel")
    public void exportExcelUsers(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=data-users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<TransferPlant> listTransferplant = transferPlantRepo.findAll();

        TransferplantExcelReporting excelExporter = new TransferplantExcelReporting(listTransferplant);

        excelExporter.export(response);
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers.reports.export;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel.AssetExcelReporting;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 *
 * @author denigunawan
 */

@Controller
public class ExportExcelController {

    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private AssetExcelReporting assetExcelReporting;

    @GetMapping("/asset/export")
    public ResponseEntity<InputStreamResource> excelReporting() throws Exception {
        List<Asset> assetList = assetRepo.findAll();
        ByteArrayInputStream in = assetExcelReporting.exportExcel(assetList);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=asset.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

    }







}

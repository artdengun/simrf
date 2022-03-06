package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "reporting/excel")
@Slf4j
@AllArgsConstructor
public class ExportExcelController {

    private AssetExcelReporting assetExcelReporting;
    private KaryawanExcelReporting karyawanExcelReporting;
    private FrozenExcelReporting frozenExcelReporting;
    private RawExcelReporting rawExcelReporting;
    private ReturExcelReporting returExcelReporting;
    private TransferPlantExcelReporting transferPlantExcelReporting;


}

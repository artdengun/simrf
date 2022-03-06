package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "upload/excel")
@Slf4j
@AllArgsConstructor
public class UploadExcelController {


    private AssetExcelReporting assetExcelReporting;
    private KaryawanExcelReporting karyawanExcelReporting;
    private FrozenExcelReporting frozenExcelReporting;
    private RawExcelReporting rawExcelReporting;
    private ReturExcelReporting returExcelReporting;
    private TransferPlantExcelReporting transferPlantExcelReporting;

}

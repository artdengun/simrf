package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel.TransferPlantExcelReporting;
import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.pdf.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "reporting/pdf")
@Slf4j
@AllArgsConstructor
public class ExportPdfController {

    private AssetPdfReporting assetPdfReporting;
    private FrozenPdfReporting frozenPdfReporting;
    private KaryawanPdfReporting karyawanPdfReporting;
    private RawPdfReporting rawPdfReporting;
    private ReturPdfReporting returPdfReporting;
    private TransferPlantExcelReporting transferPlantExcelReporting;


}

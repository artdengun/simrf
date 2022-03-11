package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.csv.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author denigunawan
 */

@Controller
@RequestMapping(value = "upload/csv")
@Slf4j
@AllArgsConstructor
public class UploadCsvController {

    private AssetCsvReporting assetCsvReporting;
    private KaryawanCsvReporting karyawanCsvReporting;
    private FrozenCsvReporting frozenCsvReporting;
    private ReturCsvReporting returCsvReporting;
    private RawCsvReporting rawCsvReporting;
    private TransferplantCsvReporting transferplantCsvReporting;

}

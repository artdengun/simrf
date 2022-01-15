package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangDcController {

    @GetMapping(value = "/barang/dc")
    private String getBarangDc() {
        return "pages/barangdc/index";
    }
}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangVendorController {

    @GetMapping(value = "/barang/vendor")
    public String getBarangMinyak() {
        return "pages/barangvendor/index";
    }
}

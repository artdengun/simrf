package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangMinyakController {

    @GetMapping(value = "/barang/minyak")
    public String getBarangMinyak() {
        return "pages/barangminyak/index";
    }

}

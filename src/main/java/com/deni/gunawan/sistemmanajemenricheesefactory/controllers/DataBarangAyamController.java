package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangAyamController {

    @GetMapping(value = "/barang/ayam")
    private String getBarangAyam() {
        return "pages/barangayam/index";
    }

}

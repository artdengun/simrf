package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangReturController {

    @GetMapping(value = "/barang/retur")
    public String getBarangRetur() {
        return "pages/barangretur/index";
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataDokumenMasukController {

    @GetMapping(value = "/dokumen/masuk")
    private String getDokumenMasuk() {
        return "pages/dokumenmasuk/index";
    }

}

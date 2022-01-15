package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataDokumenKeluarController {

    @GetMapping(value = "/dokumen/keluar")
    private String getDokumenKeluar() {
        return "pages/dokumenkeluar/index";
    }

}

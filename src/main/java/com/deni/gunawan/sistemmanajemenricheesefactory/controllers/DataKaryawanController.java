package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataKaryawanController {

    @GetMapping(value = "data/karyawan")
    public String getKaryawan() {
        return "pages/karyawan/index";
    }
}

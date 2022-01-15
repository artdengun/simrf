package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataAssetsDokumenController {

    @GetMapping(value = "/assets/dokumen")
    private String getAssetsCashier() {
        return "pages/adokumen/index";
    }
}

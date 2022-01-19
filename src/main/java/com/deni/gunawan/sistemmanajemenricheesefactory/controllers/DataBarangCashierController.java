package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangCashierController {

    @GetMapping(value = "/assets/cashier")
    private String getAssetsCashier() {
        return "pages/acashier/index";
    }
}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataBarangKitchenController {

    @GetMapping(value = "/assets/kitchen")
    private String getAssetsKitchen() {
        return "pages/akitchen/index";
    }
}

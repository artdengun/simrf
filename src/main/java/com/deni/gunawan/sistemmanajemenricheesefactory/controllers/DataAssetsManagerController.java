package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataAssetsManagerController {

    @GetMapping(value = "/assets/manager")
    public String getAssetsManager() {
        return "pages/amanager/index";
    }

}

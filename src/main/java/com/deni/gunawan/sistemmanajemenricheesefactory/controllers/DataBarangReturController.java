package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataBarangReturService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DataBarangReturController {

	
	private DataBarangReturService barangReturService;
	
	
    @GetMapping(value = "/barang/retur")
    public String getBarangRetur() {
        return "pages/barangretur/index";
    }

}

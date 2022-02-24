package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataBarangReturService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class DataBarangReturController {

	
	private DataBarangReturService barangReturService;

    @RequestMapping(value = "/retur")
    public ModelAndView getIndex(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/pages/raw/index");
        return mv;

    }

}

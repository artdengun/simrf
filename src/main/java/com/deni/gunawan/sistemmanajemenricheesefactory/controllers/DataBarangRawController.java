package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;

import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataBarangRawService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class DataBarangRawController {
	
	
	private DataBarangRawService dataBarangRawService;

	@RequestMapping(value = "/raw")
	public ModelAndView getIndex(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/pages/raw/index");
		return mv;

	}


}

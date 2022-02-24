package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;

import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataBarangTransferPlantService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class DataBarangTransferPlantController {
	
	private DataBarangTransferPlantService dataBarangTransferPlantService;

	@RequestMapping(value = "/transferplant")
	public ModelAndView getIndex(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/pages/transferplant/index");
		return mv;
	}
}

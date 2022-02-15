package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataBarangAssetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class DataBarangAssetController {

    private DataBarangAssetService dataBarangAssetService;
    

    @RequestMapping(value = "/assets")
    public ModelAndView getDataBarangService(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/pages/assets/index");
        return mv;

    }

}

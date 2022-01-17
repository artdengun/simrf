package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.DataKaryawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.DataKaryawanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DataKaryawanController {

    @Autowired
    private DataKaryawanService dataKaryawanService;

    @GetMapping(value = "/karyawan")
    public String listDataKaryawan(ModelMap map){
        map.addAttribute("listKaryawan", dataKaryawanService.getListKaryawan());
        return "/pages/karyawan/index";
    }

    @GetMapping(value = "/form")
    public String redirectToForm(DataKaryawan dataKaryawan, ModelMap params){
        params.addAttribute("karyawan", dataKaryawan);
        return "/pages/karyawan/form";
    }


    @GetMapping(value = "/form/{id}")
    public String formKaryawanById(@PathVariable(value = "id") String id, ModelMap map, RedirectAttributes redirectAttributes ){
        Optional<DataKaryawan> dataKaryawan = dataKaryawanService.findByIdKaryawan(id);
        if(dataKaryawan != null){
            map.addAttribute("karyawan", dataKaryawan);
            return "/pages/karyawan/form";
        }else{
            redirectAttributes.addFlashAttribute("Not Available", "Data Tidak Ditemukan");
            return "redirect:/karyawan";
        }

    }

    @PostMapping(value = "/submit")
    public String submitKaryawan(@Valid @ModelAttribute DataKaryawan dataKaryawan, 
                                BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "/pages/karyawan/form";
        }
        dataKaryawanService.save(dataKaryawan);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Disimpan");
        return "redirect:/karyawan";
     }


    @GetMapping(value = "/hapus/{id}")
    public String deleteKaryawanById(@PathVariable(value = "id") String id){
        dataKaryawanService.deleteKaryawan(id);
        return "redirect:/agama/index";
    }
}

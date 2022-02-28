package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.KaryawanService;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.ReturService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/retur")
@Slf4j
public class ReturController {

    private KaryawanService karyawanService;
    private ReturService returService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("karyawan", karyawanService.getList());
        map.addAttribute("retur", returService.getList());
        return "pages/retur/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        map.addAttribute("karyawan", karyawanService);
        map.addAttribute("retur", returService);
        return "pages/retur/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getDataById(@PathVariable(value = "id") String id,
                              ModelMap map,
                              RedirectAttributes redirectAttributes){
        Optional<Retur> retur = returService.findDataById(id);
        if(retur.isPresent()){
            map.addAttribute("retur", returService);
            return "/pages/retur/form";
        }else{
            redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak Ada");
            return "redirect:/retur/index";
        }
    }

    @PostMapping(value = "/submit")
    public String addData(@Valid @ModelAttribute Retur retur,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/retur/form";
        }
        returService.saved(retur);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Save");
        return "redirect:/retur/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id,
                                      RedirectAttributes redirectAttributes){
        this.returService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/retur/index";
    }



}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.KaryawanService;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.TransferPlantService;
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
@RequestMapping(value = "/transferplant")
@AllArgsConstructor
@Slf4j
public class TransferPlantController {

    private KaryawanService karyawanService;
    private TransferPlantService transferPlantService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("karyawan", karyawanService.getList());
        map.addAttribute("transferplant", transferPlantService.getList());
        return "pages/transferplant/index";
    }
    
    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        map.addAttribute("karyawan", karyawanService);
        map.addAttribute("transferplant", transferPlantService);
        return "pages/transferplant/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getDataById(@PathVariable(value = "id") String id,
                             ModelMap map,
                             RedirectAttributes redirectAttributes){
        Optional<TransferPlant> transferPlant = transferPlantService.findDataById(id);
        if(transferPlant.isPresent()){
            map.addAttribute("transferplant", transferPlantService);
            return "/pages/transferplant/form";
        }else{
            redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak Ada");
            return "redirect:/transferplant/index";
        }
    }

    @PostMapping(value = "/submit")
    public String addTransferPlant(@Valid @ModelAttribute TransferPlant transferPlant,
                           BindingResult result,
                           RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/transferplant/form";
        }
        transferPlantService.saved(transferPlant);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Save");
        return "redirect:/transferplant/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String removeTransferPlant(@PathVariable(value = "id") String id,
                              RedirectAttributes redirectAttributes){
        this.transferPlantService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/transferplant/index";
    }

}

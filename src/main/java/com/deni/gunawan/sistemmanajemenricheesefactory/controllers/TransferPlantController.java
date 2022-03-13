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

    private TransferPlantService transferPlantService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("listTransferplant", transferPlantService.getList());
        return "pages/transfer/index";
    }
    
    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        TransferPlant transferPlant = new TransferPlant();
        map.addAttribute("transfer", transferPlant);
        return "pages/transfer/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getDataById(@PathVariable(value = "id") String id,
                             ModelMap map,
                             RedirectAttributes redirectAttributes){
        Optional<TransferPlant> transferPlant = transferPlantService.findById(id);
        if(transferPlant.isPresent()){
            map.addAttribute("transferplant", transferPlantService);
            return "pages/transferplant/form";
        }else{
            redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak Ada");
            return "redirect:/transferplant/index";
        }
    }

    @PostMapping(value = "/submit")
    public String addTransferPlant(@Valid @ModelAttribute TransferPlant transferPlant, BindingResult result){
        if(result.hasErrors()){
            return "pages/transferplant/form";
        }
        transferPlantService.save(transferPlant);
        return "redirect:/transferplant/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String removeTransferPlant(@PathVariable(value = "id") String id){
        this.transferPlantService.delete(id);
        return "redirect:/transferplant/index";
    }

}

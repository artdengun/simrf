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

    private ReturService returService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("listRetur", returService.getList());
        return "pages/retur/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        Retur retur = new Retur();
        map.addAttribute("retur", retur);
        return "pages/retur/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getDataById(@PathVariable(value = "id") String id, ModelMap map){
        Optional<Retur> retur = returService.findById(id);
        if(retur.isPresent()){
            map.addAttribute("retur", returService);
            return "pages/retur/form";
        }else{
            return "redirect:/retur/index";
        }
    }

    @PostMapping(value = "/submit")
    public String addData(@Valid @ModelAttribute Retur retur, BindingResult result){
        if(result.hasErrors()){
            log.info("DATA RETUR TIDAK BERHASIL DI PROSES");
            return "pages/retur/form";
        }
        returService.save(retur);
        return "redirect:/retur/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id){
        this.returService.delete(id);
        return "redirect:/retur/index";
    }



}

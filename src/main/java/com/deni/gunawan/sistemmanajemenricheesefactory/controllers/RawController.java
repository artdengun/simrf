package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.KaryawanService;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.RawService;
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
@RequestMapping(value = "/raw")
@Slf4j
public class RawController {

    private KaryawanService karyawanService;
    private RawService rawService;

    @GetMapping(value = "/index")
    private String getList(ModelMap map){
        map.addAttribute("karyawan", karyawanService.getList());
        map.addAttribute("listRaw", rawService.getList());
        return "pages/raw/index";
    }

    @GetMapping(value = "/form")
    private String getForm(ModelMap map){
        map.addAttribute("karyawan", karyawanService);
        map.addAttribute("raw", rawService);
        return "pages/raw/form";
    }

    @GetMapping(value = "/form/{id}")
    private String findDataById(@PathVariable(value = "id") String id,
                              RedirectAttributes redirectAttributes){
        Optional<Raw> findDataId = rawService.findDataById(id);
        if(findDataId.isPresent()){
            redirectAttributes.addFlashAttribute("successAlert", "Data Ditemukan");
            return "redirect:/raw/form";
        }
        redirectAttributes.addFlashAttribute("noAvailable", "Data Tidak Ditemukan");
        return "redirect:/raw/index";
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Raw raw,
                        BindingResult result,
                        RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "pages/raw/form";
        }
        rawService.saved(raw);
        redirectAttributes.addFlashAttribute("successAlert", "Data Ditemukan");
        return "redirect:/raw/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id,
                         RedirectAttributes redirectAttributes){
        rawService.delete(id);
        redirectAttributes.addFlashAttribute("successAlert", "Data Ditemukan");
        return "redirect:/raw/index";
    }

}

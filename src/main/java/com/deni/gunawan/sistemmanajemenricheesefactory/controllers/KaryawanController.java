package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Karyawan;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.KaryawanService;
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
@RequestMapping(value = "/karyawan")
@AllArgsConstructor
@Slf4j
public class KaryawanController {

    private KaryawanService karyawanService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("karyawan", karyawanService.getList());
        return "pages/karyawan/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        map.addAttribute("karyawan", karyawanService);
        return "pages/karyawan/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getKaryawanId(@PathVariable(value = "id") String id,
                                  ModelMap map,
                                  RedirectAttributes redirectAttributes){
        Optional<Karyawan> karyawan = karyawanService.findDataById(id);
        if(karyawan.isPresent()){
            map.addAttribute("karyawan", karyawan);
            return "/pages/karyawan/form";
        }else {
            redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak Ada");
            return "redirect:pages/karyawan/index";
        }
    }

    @PostMapping("/submit")
    public String addKaryawan(@Valid @ModelAttribute Karyawan karyawan,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "redirect:/karyawan/form";
        }
        karyawanService.saved(karyawan);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Disimpan");
        return "redirect:/karyawan/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String removeKaryawan(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
        this.karyawanService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Dihapus!");
        return "redirect:/karyawan/index";
    }

}

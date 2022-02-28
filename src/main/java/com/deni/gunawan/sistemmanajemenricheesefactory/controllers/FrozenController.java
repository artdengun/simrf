package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.FrozenService;
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
@AllArgsConstructor
@RequestMapping(value = "/frozen")
@Slf4j
public class FrozenController {

        private KaryawanService karyawanService;
        private FrozenService frozenService;

        @GetMapping(value = "/index")
        public String getList(ModelMap map){
            map.addAttribute("karyawan", karyawanService.getList());
            map.addAttribute("frozen", frozenService.getList());
            return "pages/frozen/index";
        }

        @GetMapping(value = "/form")
        public String getForm(ModelMap map){
            map.addAttribute("karyawan", karyawanService);
            map.addAttribute("frozen", frozenService);
            return "/pages/frozen/form";
        }

        @GetMapping(value = "/delete/{id}")
        public String remove(@PathVariable(value = "id") String id,
                             RedirectAttributes redirectAttributes){
            this.frozenService.delete(id);
            redirectAttributes.addFlashAttribute("successAlert", "Data Berhasil di delete");
            return "redirect:/frozen/index";
        }

        @GetMapping(value = "/form/{id}")
        public String findById(@PathVariable(value = "id") String id,
                             RedirectAttributes redirectAttributes){
            Optional<Frozen> findData = frozenService.findDataById(id);
            if(findData.isPresent()){
                redirectAttributes.addFlashAttribute("successAlert", "Data Berhasil Ditampilkan");
                return "/pages/frozen/form";
            }
                redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak ditemukan");
                return "redirect:/frozen/index";
        }

        @PostMapping(value = "/submit")
        public String saved(@Valid @ModelAttribute Frozen frozen,
                            BindingResult result,
                            RedirectAttributes redirectAttributes){

            if(result.hasErrors()){
                return "/pages/frozen/form";
            }
            frozenService.saved(frozen);
            redirectAttributes.addFlashAttribute("successAlert", "Data Berhasil Disimpan");
            return "redirect:/frozen/index";
        }

}

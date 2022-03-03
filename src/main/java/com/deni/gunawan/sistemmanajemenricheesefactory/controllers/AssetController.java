package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.AssetService;
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
@RequestMapping(value = "/asset")
@AllArgsConstructor
@Slf4j
public class AssetController {

    private KaryawanService karyawanService;
    private AssetService assetService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("karyawan", karyawanService.getList());
        map.addAttribute("listAsset", assetService.getList());
        return "pages/asset/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        map.addAttribute("karyawan", karyawanService);
        map.addAttribute("asset", assetService);
        return "pages/asset/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getAssetId(@PathVariable(value = "id") String id,
                             ModelMap map,
                             RedirectAttributes redirectAttributes){
        Optional<Asset> asset = assetService.findDataById(id);
        if(asset.isPresent()){
            map.addAttribute("asset", assetService);
            return "pages/asset/form";
        }else{
            redirectAttributes.addFlashAttribute("notAvailable", "Data Tidak Ada");
            return "redirect:/karyawan/index";
        }
    }

    @PostMapping(value = "/submit")
    public String addAsset(@Valid @ModelAttribute Asset asset,
                           BindingResult result,
                           RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/asset/form";
        }
        assetService.saved(asset);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Save");
        return "redirect:/asset/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String removeAsset(@PathVariable(value = "id") String id,
                              RedirectAttributes redirectAttributes){
        this.assetService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/asset/index";
    }

}

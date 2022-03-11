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

/**
 *
 * @author denigunawan
 */

@Controller
@RequestMapping(value = "/asset")
@AllArgsConstructor
@Slf4j
public class AssetController {

    private AssetService assetService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map){
        map.addAttribute("listAsset", assetService.getList());
        return "pages/asset/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        Asset asset = new Asset();
        map.addAttribute("asset", asset);
        return "pages/asset/form";
    }

    @GetMapping(value = "/form/{id}")
    public String getAssetId(@PathVariable(value = "id") String id, ModelMap map){
        Optional<Asset> asset = assetService.findDataById(id);
            map.addAttribute("asset", asset);
            return "pages/asset/edit";
    }

    @PostMapping(value = "/submit")
    public String addAsset( @Valid @ModelAttribute Asset asset, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "pages/asset/form";
        }
        assetService.saved(asset);
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

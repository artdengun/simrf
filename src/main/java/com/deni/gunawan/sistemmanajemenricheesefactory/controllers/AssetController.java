package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.AssetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
    private AssetRepo assetRepo;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listAsset", assetRepo.findAll(pageable));
        return "pages/asset/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        Asset asset = new Asset();
        map.addAttribute("asset", asset);
        return "pages/asset/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model,  @PathVariable(value = "id") String id){
        try {
            Asset asset = assetService.findDataById(id)
                    .orElseThrow(()
                    -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("asset", asset);
            return "pages/asset/edit";
        }catch (Exception e){
            return "pages/asset/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "asset") Asset asset) {
        {
            model.addAttribute("asset", asset);
            assetService.saved(asset);
            return "redirect:/asset/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved( @Valid @ModelAttribute Asset asset, BindingResult result){
        if(result.hasErrors()){
            return "pages/asset/form";
        }
        assetService.saved(asset);
        return "redirect:/asset/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id,
                              RedirectAttributes redirectAttributes){
        this.assetService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/asset/index";
    }

    // public generateExcel
    // public GeneratePDF


}

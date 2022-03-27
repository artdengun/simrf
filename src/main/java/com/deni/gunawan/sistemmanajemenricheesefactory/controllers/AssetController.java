package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.AssetService;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.KaryawanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
    public String getAssetId(@PathVariable(value = "id") String id){
        Optional<Asset> asset = Optional.ofNullable(assetService.findDataById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Asset Id : " + id)));
            return "pages/asset/edit";
    }

    @PostMapping("/asset/update/{id}")
    public String updateData(@PathVariable(value = "id") String id, @Valid Asset asset,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            asset.setId(id);
            return "pages/asset/edit";
        }
       assetService.update(asset);
        return "redirect:/asset/index";
    }

    @PostMapping(value = "/submit")
    public String addAsset( @Valid @ModelAttribute Asset asset, BindingResult result){
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

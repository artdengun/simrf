package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.ReturService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String showEditForm(Model model, @PathVariable(value = "id") String id){
        try {
            Retur retur = returService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("retur", retur);
            return "pages/retur/edit";
        }catch (Exception e){
            return "pages/retur/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "retur") Retur retur) {
        {
            model.addAttribute("retur", retur);
            returService.save(retur);
            return "redirect:/retur/index";
        }
    }


    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Retur retur, BindingResult result){
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



    // public generateExcel
    // public GeneratePDF

}

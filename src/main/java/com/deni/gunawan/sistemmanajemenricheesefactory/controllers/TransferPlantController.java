package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.TransferPlantRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.TransferPlantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/transferplant")
@AllArgsConstructor
@Slf4j
public class TransferPlantController {

    private TransferPlantService transferPlantService;
    private TransferPlantRepo transferPlantRepo;
    private UserRepo usersRepo;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listTransferplant", transferPlantRepo.findAll(pageable));
        map.addAttribute("listUsers", usersRepo.findAll());
        return "pages/transferplant/index";
    }
    
    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        TransferPlant transferplant = new TransferPlant();
        map.addAttribute("transferplant", transferplant);
        map.addAttribute("users", usersRepo.findAll());
        return "pages/transferplant/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") Long id){
        try {
            TransferPlant transferplant = transferPlantService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("transferplant", transferplant);
            model.addAttribute("users", usersRepo.findAll());
            return "pages/transferplant/edit";
        }catch (Exception e){
            return "pages/transferplant/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "transferPlant") TransferPlant transferplant) {
        {
            model.addAttribute("transferPlant", transferplant);
            transferPlantService.save(transferplant);
            return "redirect:/transferplant/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute TransferPlant transferPlant, BindingResult result){
        if(result.hasErrors()){
            return "pages/transferplant/form";
        }
        transferPlantService.save(transferPlant);
        return "redirect:/transferplant/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") Long id){
        transferPlantService.delete(id);
        return "redirect:/transferplant/index";
    }

}

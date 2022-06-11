package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.ReturRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.ReturService;
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
@AllArgsConstructor
@RequestMapping(value = "/retur")
@Slf4j
public class ReturController {

    private ReturService returService;
    private ReturRepo returRepo;
    private UserRepo usersRepo;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listRetur", returRepo.findAll(pageable));
        map.addAttribute("listUsers", usersRepo.findAll());
        return "pages/retur/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        Retur retur = new Retur();
        map.addAttribute("retur", retur);
        map.addAttribute("users", usersRepo.findAll());
        return "pages/retur/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") Long id){
        try {
            Retur retur = returService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("retur", retur);
            model.addAttribute("users", usersRepo.findAll());
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
            return "redirect:pages/retur/index";
        }
    }


    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Retur retur, BindingResult result){
        if(result.hasErrors()){
            log.info("DATA RETUR TIDAK BERHASIL DI PROSES");
            return "pages/retur/form";
        }
        returService.save(retur);
        return "redirect:pages/retur/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") Long id){
        this.returService.delete(id);
        return "redirect:pages/retur/index";
    }

}

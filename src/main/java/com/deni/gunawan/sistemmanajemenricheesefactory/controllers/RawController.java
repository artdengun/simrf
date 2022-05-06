package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RawRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.RawService;
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
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/raw")
@Slf4j
public class RawController {

    private RawService rawService;
    private RawRepo rawRepo;
    private UsersRepo usersRepo;

    @GetMapping(value = "/index")
    private String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listRaw", rawRepo.findAll(pageable));
        map.addAttribute("listUsers", usersRepo.findAll());
        return "pages/raw/index";
    }

    @GetMapping(value = "/form")
    private String getForm(ModelMap map){
        Raw raw = new Raw();
        map.addAttribute("raw", raw);
        map.addAttribute("users", usersRepo.findAll());
        return "pages/raw/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") String id){
        try {
            Raw raw = rawService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("raw", raw);
            model.addAttribute("users", usersRepo.findAll());
            return "pages/raw/edit";
        }catch (Exception e){
            return "pages/raw/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "raw") Raw raw) {
        {
            model.addAttribute("raw", raw);
            rawService.save(raw);
            return "redirect:/raw/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Raw raw, BindingResult result){
        if(result.hasErrors()){
            return "pages/raw/form";
        }
        rawService.save(raw);
        return "redirect:/raw/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id,
                         RedirectAttributes redirectAttributes){
        rawService.delete(id);
        redirectAttributes.addFlashAttribute("successAlert", "Data Ditemukan");
        return "redirect:/raw/index";
    }



    // public generateExcel
    // public GeneratePDF
}

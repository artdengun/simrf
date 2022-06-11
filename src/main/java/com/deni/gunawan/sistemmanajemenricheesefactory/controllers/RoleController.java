package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Roles;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/roles/")
@AllArgsConstructor
public class RoleController {

    private RoleRepo roleRepo;
    private RoleService roleService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable) {
        map.addAttribute("listRole", roleRepo.findAll(pageable));
        return "pages/roles/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map) {
        Roles roles = new Roles();
        map.addAttribute("roles", roles);
        return "pages/roles/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") Long id) {
        try {
            Roles roles = roleService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("roles", roles);
            return "pages/roles/edit";
        } catch (Exception e) {
            return "pages/roles/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "roles") Roles roles) {
        {
            model.addAttribute("roles", roles);
            roleService.save(roles);
            return "redirect:/roles/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Roles roles, BindingResult result) {
        if (result.hasErrors()) {
            return "pages/roles/form";
        }
        roleService.save(roles);
        return "redirect:/roles/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") Long id,
                         RedirectAttributes redirectAttributes) {
        this.roleService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/roles/index";
    }

}

package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Role;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.RoleService;
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
@RequestMapping(value = "/role")
@AllArgsConstructor
@Slf4j
public class RoleController {

    private RoleService roleService;
    private RoleRepo roleRepo;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable) {
        map.addAttribute("listRole", roleRepo.findAll(pageable));
        return "pages/role/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map) {
        Role role = new Role();
        map.addAttribute("role", role);
        return "pages/role/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") String id) {
        try {
            Role role = roleService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("role", role);
            return "pages/role/edit";
        } catch (Exception e) {
            return "pages/role/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "role") Role role) {
        {
            model.addAttribute("role", role);
            roleService.save(role);
            return "redirect:/role/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute Role role, BindingResult result) {
        if (result.hasErrors()) {
            return "pages/role/form";
        }
        roleService.save(role);
        return "redirect:/role/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id) {
        try {
            roleService.delete(id);
        } catch (Exception e) {
            log.error("MESSAGE = [{}]", e.getMessage());
            log.info("STACKTRACE = [{}]", e.getStackTrace());
        }
        return "redirect:/role/index";
    }
}

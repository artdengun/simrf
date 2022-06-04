package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.User;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users/")
@AllArgsConstructor
public class UsersController {

    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private UserService userService;

    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable) {
        map.addAttribute("roles", roleRepo.findAll());
        map.addAttribute("listUser", userRepo.findAll(pageable));
        return "pages/users/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map) {
        User users = new User();
        map.addAttribute("users", users);
        map.addAttribute("roles", roleRepo.findAll());
        return "pages/users/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") Long id) {
        try {
            User users = userService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("users", users);
            model.addAttribute("roles", roleRepo.findAll());
            return "pages/users/edit";
        } catch (Exception e) {
            return "pages/users/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "users") User users) {
        {
            model.addAttribute("users", users);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(users.getPassword());
            users.setPassword(encodedPassword);
            userService.save(users);
            return "redirect:/users/index";
        }
    }

    @PostMapping(value = "/submit")
    public String saved(@Valid @ModelAttribute User users, BindingResult result) {
        if (result.hasErrors()) {
            return "pages/users/form";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        userService.save(users);
        return "redirect:/users/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") Long id,
                         RedirectAttributes redirectAttributes) {
        this.userService.delete(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data Berhasil Remove");
        return "redirect:/users/index";
    }

}

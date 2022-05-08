package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/users")
@Slf4j
@AllArgsConstructor
public class UsersController {

    private UsersService usersService;
    private UsersRepo usersRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listUsers", usersRepo.findAll(pageable));
        return "pages/users/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        Users users = new Users();
        map.addAttribute("users", users);
        map.addAttribute("role", roleRepo.findAll());
        return "pages/users/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") String id){
        try {

            Users users = usersService.findUsersById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("users", users);
            model.addAttribute("role", roleRepo.findAll());
            return "pages/users/edit";
        }catch (Exception e){
            return "pages/users/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, Users user) {
            model.addAttribute("users", user);
            usersService.save(user);
            return "redirect:/users/index";
    }

    @PostMapping(value = "/submit")
    public String saved(Users users, Model model, BindingResult result){

        if(result.hasErrors()){
            return "pages/users/form";
        }
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            usersService.save(users);
            return "redirect:/users/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id){
        usersService.delete(id);
        return "redirect:/users/index";
    }

}

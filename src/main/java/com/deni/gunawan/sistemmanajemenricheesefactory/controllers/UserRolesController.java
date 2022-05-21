package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.UserRoles;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.RoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UserRoleRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/userrole")
@Slf4j
public class UserRolesController {
    
    private UserRoleService userRoleService;
    private UsersRepo usersRepo;
    private UserRoleRepo userRoleRepo;
    private RoleRepo roleRepo;
    
    @GetMapping(value = "/index")
    public String getList(ModelMap map, Pageable pageable){
        map.addAttribute("listUserRole", userRoleRepo.findAll(pageable));
        return "pages/userrole/index";
    }

    @GetMapping(value = "/form")
    public String getForm(ModelMap map){
        UserRoles userrole = new UserRoles();
        map.addAttribute("userrole", userrole);
        map.addAttribute("role", roleRepo.findAll());
        map.addAttribute("user", usersRepo.findAll());
        return "pages/userrole/form";
    }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") String id){
        try {

            UserRoles userrole = userRoleService.findUsersById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("userrole", userrole);
            model.addAttribute("role", roleRepo.findAll());
            model.addAttribute("user", usersRepo.findAll());
            return "pages/userrole/edit";
        }catch (Exception e){
            return "pages/userrole/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, UserRoles user) {
        model.addAttribute("userrole", user);

        userRoleService.save(user);
        return "redirect:/userrole/index";
    }

    @PostMapping(value = "/submit")
    public String saved(UserRoles userroles, Model model, BindingResult result){

        if(result.hasErrors()){
            return "pages/userrole/form";
        }
        userRoleRepo.save(userroles);
        return "redirect:/userrole/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable(value = "id") String id){
        userRoleService.delete(id);
        return "redirect:/userrole/index";
    }
    
}

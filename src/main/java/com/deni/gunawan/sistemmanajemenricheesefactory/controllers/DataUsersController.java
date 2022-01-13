package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataUsersController {

    @GetMapping(value = "/users")
    private String getUsers() {
        return "pages/users/index";
    }

}

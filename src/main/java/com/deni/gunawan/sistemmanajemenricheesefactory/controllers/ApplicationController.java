package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(value = "/")
    public String routeFrontend() {
        return "pages/frontend/index";
    }

    @GetMapping(value = "/index")
    public String routeDashboard(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String routeLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String routeLogout(){
        return "login";
    }

    @GetMapping(value = "/notfound")
    public String routeNotFound(){return "pages/error/404";}
}

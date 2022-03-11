package com.deni.gunawan.sistemmanajemenricheesefactory.config.appcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(value = "/")
    public String routeFrontend() {
        return "pages/frontend/index";
    }

    @GetMapping(value = "/dashboard")
    public String routeIndex() {
        return "blank";
    }

    @GetMapping(value = "/index")
    public String routeDashboard(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String routeLogin() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String routeRegister() {
        return "register";
    }

    @GetMapping(value = "/table")
    public String routerBasiTable() {
        return "tables";
    }

    @GetMapping(value = "/form")
    public String getTables() {
        return "form";
    }
}

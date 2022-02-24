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
        return "pages/tables/basic";
    }

    @GetMapping(value = "/element")
    public String routerFormBasic() {
        return "pages/forms/basic_elements";
    }

    @GetMapping(value = "/not-found")
    public String errorNotFound() {
        return "pages/error/404";
    }

    @GetMapping(value = "/err-server")
    public String errorServerNotResponse() {
        return "pages/error/500";
    }

    @GetMapping(value = "/asset-index")
    public String assetsIndex(){
        return "pages/assets/index";
    }

}

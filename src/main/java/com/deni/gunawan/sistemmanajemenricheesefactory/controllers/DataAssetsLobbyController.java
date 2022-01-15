package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataAssetsLobbyController {

    @GetMapping(value = "/assets/lobby")
    public String getAssetsLobby() {
        return "pages/alobby/index";
    }

}

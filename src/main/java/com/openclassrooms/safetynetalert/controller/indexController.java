package com.openclassrooms.safetynetalert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class indexController {

    @GetMapping("/")
    public String index(){
        return "index" ;

    }
}



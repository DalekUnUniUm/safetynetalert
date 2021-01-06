package com.openclassrooms.safetynetalert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(){
        return "index" ;

    }
}



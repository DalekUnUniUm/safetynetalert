package com.openclassrooms.safetynetalert.controller;

import com.openclassrooms.safetynetalert.service.ReponseService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReponseController {

    @Autowired
    private ReponseService reponseService ;

    @RequestMapping(value = "firestation" , method = RequestMethod.GET)
    public JSONArray personsByStation(@RequestParam("stationNumber") String station_number){

        System.out.println("Test = " + station_number);

        return reponseService.personsByStation(station_number);
    }


}

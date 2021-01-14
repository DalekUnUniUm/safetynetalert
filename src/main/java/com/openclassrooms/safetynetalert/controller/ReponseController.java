package com.openclassrooms.safetynetalert.controller;

import com.openclassrooms.safetynetalert.service.ReponseService;
import org.json.simple.JSONArray;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReponseController {
    @Autowired
    private ReponseService reponseService ;

    /**Endpoint de firestation?stationNumber=<station_number**/
    @RequestMapping(value = "firestation" , method = RequestMethod.GET)
    public JSONArray personsByStation(@RequestParam("stationNumber") String station_number){
        Logger.info("stationnumber: " + station_number);
        return reponseService.personsByStation(station_number);
    }
    /**Endpoint de childAlert?address=<address>**/
    @RequestMapping(value = "childAlert", method = RequestMethod.GET)
    public JSONArray childrenByAddress(@RequestParam("address") String address){
        Logger.info("address: " + address);
        return reponseService.childrenByAddress(address);
    }
    /**Endpoint de phoneAlert?firestation=<firestation_number>**/
    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public JSONArray phoneByStation(@RequestParam("firestation") String firestation_number){
        Logger.info("firestation: " + firestation_number);
        return reponseService.phoneByStation(firestation_number);
    }
    /**Endpoint de fire?address=<address>**/
    @RequestMapping(value = "fire", method = RequestMethod.GET)
    public JSONArray personsByAddress(@RequestParam("address") String address){
        Logger.info("address: " + address);
        return reponseService.personsByAddress(address);
    }
    /**Endpoint de flood/stations?stations=<a list of station_number>**/
    @RequestMapping(value = "/flood/stations", method = RequestMethod.GET)
    public JSONArray famillyByAddress(@RequestParam("stations")String stations){
        Logger.info("stations: " + stations);
        return reponseService.famillyByAddress(stations);
    }
    /**Endpont de personInfo?firstName=<firstName>&lastName=<lastName>**/
    @RequestMapping(value= "personInfo" , method = RequestMethod.GET)
    public JSONArray personsInfoByName(@RequestParam("firstName") String firstName ,
                                       @RequestParam("lastName") String lastName){
        Logger.info("firstName: " + firstName + " lastName: " + lastName);

        return reponseService.personsInfoByName(firstName,lastName) ;
    }
    /**Endpoint de communityEmail?city=<city>**/
    @RequestMapping(value = "communityEmail", method = RequestMethod.GET)
    public JSONArray emailByCity(@RequestParam("city") String city){
        Logger.info("City: " + city);
        return reponseService.emailByCity(city);
    }
}

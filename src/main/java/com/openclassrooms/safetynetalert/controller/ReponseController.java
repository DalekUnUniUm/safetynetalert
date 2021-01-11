package com.openclassrooms.safetynetalert.controller;

import com.openclassrooms.safetynetalert.model.Persons;
import com.openclassrooms.safetynetalert.service.ReponseService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.Period;

@RestController
public class ReponseController {

    @Autowired
    private ReponseService reponseService ;

    /**Endpoint de firestation?stationNumber=<station_number**/
    @RequestMapping(value = "firestation" , method = RequestMethod.GET)
    public JSONArray personsByStation(@RequestParam("stationNumber") String station_number){

        System.out.println("Test = " + station_number);

        return reponseService.personsByStation(station_number);
    }
    /**Endpoint de childAlert?address=<address>**/
    @RequestMapping(value = "childAlert", method = RequestMethod.GET)
    public JSONArray childrenByAddress(@RequestParam("address") String address){
        System.out.println("Test = " + address);
        return reponseService.childrenByAddress(address);
    }
    /**Endpoint de phoneAlert?firestation=<firestation_number>**/
    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public JSONArray phoneByStation(@RequestParam("firestation") String firestation_number){
        System.out.println("Test = " + firestation_number);
        return reponseService.phoneByStation(firestation_number);
    }
    /**Endpoint de fire?address=<address>**/
    @RequestMapping(value = "fire", method = RequestMethod.GET)
    public JSONArray personsByAddress(@RequestParam("address") String address){
        System.out.println("Test = " + address);
        return reponseService.personsByAddress(address);
    }
    /**Endpoint de flood/stations?stations=<a list of station_number>**/
    @RequestMapping(value = "/flood/stations", method = RequestMethod.GET)
    public JSONArray famillyByAddress(@RequestParam("stations")String stations){
        System.out.println("Test = " + stations);
        return reponseService.famillyByAddress(stations);
    }
    /**Endpont de personInfo?firstName=<firstName>&lastName=<lastName>**/
    @RequestMapping(value= "personInfo" , method = RequestMethod.GET)
    public JSONArray personsInfoByName(@RequestParam("firstName") String firstName ,
                                       @RequestParam("lastName") String lastName){
        System.out.println("FirstName = " + firstName + " LastName = " + lastName);

        return reponseService.personsInfoByName(firstName,lastName) ;
    }
    /**Endpoint de communityEmail?city=<city>**/
    @RequestMapping(value = "communityEmail", method = RequestMethod.GET)
    public JSONArray emailByCity(@RequestParam("city") String city){
        System.out.println("Test =" + city);
        return reponseService.emailByCity(city);
    }
}

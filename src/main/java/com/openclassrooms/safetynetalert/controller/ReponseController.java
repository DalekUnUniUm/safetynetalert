package com.openclassrooms.safetynetalert.controller;

import com.openclassrooms.safetynetalert.service.ReponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.simple.JSONArray;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReponseController {
    @Autowired
    private ReponseService reponseService ;

    /**Endpoint de firestation?stationNumber=<station_number**/
    @ApiOperation(value = "Récupere une liste de personnes couvertes par la caserne de pompiers correspondantes")
    @RequestMapping(value = "firestation" , method = RequestMethod.GET)
    public JSONArray personsByStation(
            @ApiParam(value = "Numéro de station requis", required = true)
            @RequestParam("stationNumber") String station_number){
        Logger.info("stationnumber: " + station_number);
        return reponseService.personsByStation(station_number);
    }
    /**Endpoint de childAlert?address=<address>**/
    @ApiOperation(value = "Renvoie une liste d’enfants habitant à l’adresse indiqué.")
    @RequestMapping(value = "childAlert", method = RequestMethod.GET)
    public JSONArray childrenByAddress(
            @ApiParam(value = "Une adresse est démandé", required = true)
            @RequestParam("address") String address){
        Logger.info("address: " + address);
        return reponseService.childrenByAddress(address);
    }
    /**Endpoint de phoneAlert?firestation=<firestation_number>**/
    @ApiOperation(value = "Renvoie les numéros de téléphone selon un numéro de caserne")
    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public JSONArray phoneByStation(
            @ApiParam(value = "Numéro de station requis", required = true)
            @RequestParam("firestation") String firestation_number){
        Logger.info("firestation: " + firestation_number);
        return reponseService.phoneByStation(firestation_number);
    }
    /**Endpoint de fire?address=<address>**/
    @ApiOperation(value = "Renvoie une liste des habitants vivant à l'adresse entrée.")
    @RequestMapping(value = "fire", method = RequestMethod.GET)
    public JSONArray personsByAddress(
            @ApiParam(value = "Une adresse est requis", required = true)
            @RequestParam("address") String address){
        Logger.info("address: " + address);
        return reponseService.personsByAddress(address);
    }
    /**Endpoint de flood/stations?stations=<a list of station_number>**/
    @ApiOperation(value = "Renvoie une liste de tous les foyers désservis par la caserne")
    @RequestMapping(value = "/flood/stations", method = RequestMethod.GET)
    public JSONArray famillyByAddress(
            @ApiParam(value = "Numéro de station requis", required = true)
            @RequestParam("stations")String stations){
        Logger.info("stations: " + stations);
        return reponseService.famillyByAddress(stations);
    }
    /**Endpont de personInfo?firstName=<firstName>&lastName=<lastName>**/
    @ApiOperation("Renvoie une liste de personnes selon le nom et prénom")
    @RequestMapping(value= "personInfo" , method = RequestMethod.GET)
    public JSONArray personsInfoByName(
            @ApiParam(value = "Un prénom requis", required = true)
            @RequestParam("firstName") String firstName ,
            @ApiParam(value = "Un nom requis", required = true)
            @RequestParam("lastName") String lastName){
        Logger.info("firstName: " + firstName + " lastName: " + lastName);

        return reponseService.personsInfoByName(firstName,lastName) ;
    }
    /**Endpoint de communityEmail?city=<city>**/
    @ApiOperation(value = "Renvoie une liste d'email selon la ville renseignée")
    @RequestMapping(value = "communityEmail", method = RequestMethod.GET)
    public JSONArray emailByCity(
            @ApiParam(value = "Le nom d'une ville est requis", required = true)
            @RequestParam("city") String city){
        Logger.info("City: " + city);
        return reponseService.emailByCity(city);
    }
}

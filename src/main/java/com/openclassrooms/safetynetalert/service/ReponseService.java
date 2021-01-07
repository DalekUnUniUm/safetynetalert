package com.openclassrooms.safetynetalert.service;

import com.openclassrooms.safetynetalert.repository.ReponseRepository;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepository ;

    /**Endpoint de firestation?stationNumber=<station_number**/
    public JSONArray personsByStation(String station_number){
        return reponseRepository.personByStation(station_number);
    }
    /**Endpoint de childAlert?address=<address>**/
    public JSONArray childrenByAddress(String address){
        return reponseRepository.childrenByAddress(address);
    }
    /**Endpoint de phoneAlert?firestation=<firestation_number>**/
    public JSONArray phoneByStation(String firestation_number){
        return reponseRepository.phoneByStation(firestation_number);
    }
    /**Endpoint de fire?address=<address>**/
    public JSONArray personsByAddress(String address){
        return reponseRepository.personsByAddress(address);
    }
    /**Endpoint de flood/stations?stations=<a list of station_number>**/
    public JSONArray famillyByAddress(String stations){
        return reponseRepository.famillyByAddress(stations);
    }
    /**Endpont de personInfo?firstName=<firstName>&lastName=<lastName>**/
    public JSONArray personsInfoByName(String firstName , String lastName){
        return reponseRepository.personsInfoByName(firstName,lastName);
    }
    /**Endpoint de communityEmail?city=<city>**/
    public JSONArray emailByCity(String city){
        return reponseRepository.emailByCity(city);
    }

}

package com.openclassrooms.safetynetalert.service;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.config.UrlFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckerService {

    @Autowired
    private LoadDataJSON loadDataJSON ;
    @Autowired
    private UrlFileReader urlFileReader ;

    public void checkingLoadDataJSon(){
        System.out.println("Loading DataJson ...");
        System.out.println("-----------------");
        System.out.println("--Load Persons--");
        if(loadDataJSON.loadPersons(urlFileReader.urlDataJSONTest()) == true){
            System.out.println("SUCCESS");
        }else if(loadDataJSON.loadPersons(urlFileReader.urlDataJSONTest()) == false){
            System.out.println("ERROR");
        }
        System.out.println("--Load FireStations--");
        if(loadDataJSON.loadFireStations(urlFileReader.urlDataJSONTest()) == true){
            System.out.println("SUCCESS");
        }else if(loadDataJSON.loadFireStations(urlFileReader.urlDataJSONTest()) == false){
            System.out.println("ERROR");
        }
        System.out.println("--Load Medical Records--");
        if(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSONTest()) == true){
            System.out.println("SUCCESS");
        }else if(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSONTest()) == false){
            System.out.println("ERROR");
        }
        System.out.println("-----------------");
        System.out.println("Loading over");
    }

}

package com.openclassrooms.safetynetalert.service;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.config.UrlFileReader;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckerService {

    @Autowired
    private LoadDataJSON loadDataJSON ;
    @Autowired
    private UrlFileReader urlFileReader ;

    public void checkingLoadDataJSon(){
        Logger.debug("Loading DataJson ...");
        Logger.debug("Load Persons");
        if(loadDataJSON.loadPersons(urlFileReader.urlDataJSON())== true){
            Logger.debug("SUCCESS");
        }else if(loadDataJSON.loadPersons(urlFileReader.urlDataJSON()) == false){
            Logger.debug("ERROR");
        }
        Logger.debug("Load FireStations");
        if(loadDataJSON.loadFireStations(urlFileReader.urlDataJSON()) == true){
            Logger.debug("SUCCESS");
        }else if(loadDataJSON.loadFireStations(urlFileReader.urlDataJSON()) == false){
            Logger.debug("ERROR");
        }
        Logger.debug("Load Medical Records");
        if(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSON()) == true){
            Logger.debug("SUCCESS");
        }else if(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSON()) == false){
            Logger.debug("ERROR");
        }
        Logger.debug("Loading over");
    }

}

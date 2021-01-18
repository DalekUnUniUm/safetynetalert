package com.openclassrooms.safetynetalert.config;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component
public class UrlFileReader {

    public String urlDataJSON(){
        Logger.debug("getUrlDataJSON");
        String url = "C:/Users/Romuald/Desktop/Exercice OCR/Developpement d'application java/Projet 5/safetynetalert/src/main/resources/data.json" ;

        return url ;
    }
    public String urlDataJSONTest(){
        Logger.debug("getUrlDataJSONTest");
        String url = "C:/Users/Romuald/Desktop/Exercice OCR/Developpement d'application java/Projet 5/safetynetalert/src/main/resources/dataTest.json" ;

        return url ;
    }

}

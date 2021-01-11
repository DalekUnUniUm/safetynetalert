package com.openclassrooms.safetynetalert.config;

import org.springframework.stereotype.Component;

@Component
public class UrlFileReader {

    public String urlDataJSON(){
        String url = "C:/Users/Romuald/Desktop/Exercice OCR/Developpement d'application java/Projet 5/safetynetalert/src/main/resources/data.json" ;

        return url ;
    }
    public String urlDataJSONTest(){
        String url = "C:/Users/Romuald/Desktop/Exercice OCR/Developpement d'application java/Projet 5/safetynetalert/src/main/resources/dataTest.json" ;

        return url ;
    }

}

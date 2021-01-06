package com.openclassrooms.safetynetalert.service;

import com.openclassrooms.safetynetalert.repository.ReponseRepository;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepository ;

    public JSONArray personsByStation(String station_number){
        return reponseRepository.personByStation(station_number);
    }

}

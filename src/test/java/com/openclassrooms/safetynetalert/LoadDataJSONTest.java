package com.openclassrooms.safetynetalert;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.config.UrlFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Component
public class LoadDataJSONTest {

    @Autowired
    private LoadDataJSON loadDataJSON ;
    @Autowired
    private UrlFileReader urlFileReader ;

    @Test
    public void loadPersonsTest(){

        assertTrue(loadDataJSON.loadPersons(urlFileReader.urlDataJSONTest()));
    }
    @Test
    public void loadFireStationTest(){
        assertTrue(loadDataJSON.loadFireStations(urlFileReader.urlDataJSONTest()));
    }
    @Test
    public void loadMedicalRecordTest(){
        assertTrue(loadDataJSON.loadMedicalRecords(urlFileReader.urlDataJSONTest()));
    }

}

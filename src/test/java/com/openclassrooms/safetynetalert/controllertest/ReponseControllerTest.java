package com.openclassrooms.safetynetalert.controllertest;

import com.openclassrooms.safetynetalert.LoadDataJSONTest;
import com.openclassrooms.safetynetalert.controller.ReponseController;
import com.openclassrooms.safetynetalert.model.Persons;
import com.openclassrooms.safetynetalert.service.ReponseService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReponseControllerTest {

    @Autowired
    private ReponseService reponseService ;
    @Autowired
    private ReponseController reponseController ;

    private JSONArray exit ;
    private JSONArray exitTestArr ;
    private JSONObject exitTestObj ;
    private JSONArray testArr ;


    @BeforeEach
    private void setUpPerTest(){

        exit = new JSONArray();
        exitTestArr = new JSONArray();
        exitTestObj = new JSONObject();
        testArr = new JSONArray();

    }

    @Test
    public void personsInfoByNameTest(){
        exitTestObj.put("lastName", "Boyd");
        exitTestObj.put("address", "1509 Culver St");
        exitTestObj.put("age", 36);
        testArr.add("aznol:350mg");
        testArr.add("hydrapermazol:100mg");
        exitTestObj.put("medicament", testArr);
        testArr = new JSONArray();
        testArr.add("nillacilan");
        exitTestObj.put("allergies", testArr);
        exitTestArr.add(exitTestObj);

        exit = reponseController.personsInfoByName("John","Boyd");

        assertEquals(exitTestArr,exit);
    }
    @Test
    public void personsByStationTest(){
        exitTestObj.put("firstName","John");
        exitTestObj.put("lastName","Boyd");
        exitTestObj.put("address","1509 Culver St");
        exitTestObj.put("phone","841-874-6512");
        exitTestArr.add(exitTestObj);
        exitTestArr.add("Nombre(s) mineur(s) = " + 0);
        exitTestArr.add("Nombre(s) adulte(s) = " + 1);

        exit = reponseController.personsByStation("3");

        assertEquals(exit, exitTestArr);
    }
    @Test
    public void childrenByAddressWithoutChildTest(){
        exit = reponseController.childrenByAddress("1509 Culver St");

        assertEquals(exitTestArr,exit);

    }
    @Test
    public void childrenByAddressWithChildTest(){
        exitTestObj.put("firstName","Zach");
        exitTestObj.put("lastName", "Cooper");
        exitTestObj.put("age",10);
        exitTestArr.add(exitTestObj);
        testArr.add("firstName: Zach");
        testArr.add("lastName: Cooper");
        exitTestArr.add(testArr);

        exit = reponseController.childrenByAddress("489 Manchester St");

        assertEquals(exitTestArr,exit);

    }
    @Test
    public void familyByAddressTest(){
        exitTestObj.put("address", "1509 Culver St");
        exitTestArr.add(exitTestObj);
        exitTestObj = new JSONObject();
        testArr.add("nillacilan");
        exitTestObj.put("allergies",testArr);
        exitTestObj.put("lastName","Boyd");
        exitTestObj.put("phone","841-874-6512");
        testArr = new JSONArray();
        testArr.add("aznol:350mg");
        testArr.add("hydrapermazol:100mg");
        exitTestObj.put("medicament", testArr);
        exitTestObj.put("age", 36);
        exitTestArr.add(exitTestObj);

        exit = reponseController.famillyByAddress("3");
        assertEquals(exitTestArr,exit);

    }
    @Test
    public void personsByAddressTest(){
        exitTestObj.put("Station","3");
        exitTestArr.add(exitTestObj);

        exitTestObj = new JSONObject();
        exitTestObj.put("lastName", "Boyd");
        exitTestObj.put("phone", "841-874-6512");
        exitTestObj.put("age ", 36);
        testArr.add("aznol:350mg");
        testArr.add("hydrapermazol:100mg");
        exitTestObj.put("medicament", testArr);
        testArr = new JSONArray();
        testArr.add("nillacilan");
        exitTestObj.put("allergies", testArr);
        exitTestArr.add(exitTestObj);

        exit = reponseController.personsByAddress("1509 Culver St");

        assertEquals(exitTestArr,exit);
    }
    @Test
    public void phoneByStationTest(){
        exitTestObj.put("phone", "841-874-6512");
        exitTestArr.add(exitTestObj);

        exit = reponseController.phoneByStation("3");

        assertEquals(exitTestArr,exit);
    }
    @Test
    public void emailByCityTest(){
        exitTestObj.put("email","jaboyd@email.com");
        exitTestArr.add(exitTestObj);
        exitTestObj = new JSONObject();
        exitTestObj.put("email","zaco@email.com");
        exitTestArr.add(exitTestObj);

        exit = reponseController.emailByCity("Culver");

        assertEquals(exitTestArr,exit);
    }

}

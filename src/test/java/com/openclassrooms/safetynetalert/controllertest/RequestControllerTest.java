package com.openclassrooms.safetynetalert.controllertest;

import com.openclassrooms.safetynetalert.config.UrlFileReader;
import com.openclassrooms.safetynetalert.controller.RequestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RequestControllerTest {

    @Autowired
    private RequestController requestController ;
    @Autowired
    private UrlFileReader urlFileReader ;

    private String msg ;
    private JSONObject objStr ;
    private JSONArray arrStr ;

    @BeforeEach
    private void setUpPerTest(){
        msg = "" ;
        objStr = new JSONObject();
        arrStr = new JSONArray();
    }
    @Test
    @Order(1)
    public void createPersonsTest(){
        objStr.put("firstName", "Jacques");
        objStr.put("lastName" , "Flamme");
        objStr.put("address", "112 Steppes Pl");
        objStr.put("city","Culver");
        objStr.put("zip","97451");
        objStr.put("phone","841-874-65220");
        objStr.put("email","tenz@email.com");

        msg = requestController.createPerson(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(2)
    public void updatePersonsTest(){
        objStr.put("firstName", "Jacques");
        objStr.put("lastName" , "Flamme");
        objStr.put("address", "112 Steppes Pl");
        objStr.put("city","Culver");
        objStr.put("zip","97451");
        objStr.put("phone","841-874-65122");
        objStr.put("email","jacFl@email.com");

        msg = requestController.updatePerson(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(3)
    public void deletePersonsTest(){
        objStr.put("firstName", "Jacques");
        objStr.put("lastName" , "Flamme");

        msg = requestController.deletePerson(objStr.toJSONString());

        assertEquals("700",msg);
    }

    @Test
    @Order(4)
    public void createFireStationTest(){
        objStr.put("address","29 15th St");
        objStr.put("station","2");

        msg = requestController.createFireStation(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(5)
    public void updateFireStationTest(){
        objStr.put("address","29 15th St");
        objStr.put("station","4");

        msg = requestController.updateFireStation(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(6)
    public void deleteFireStationTest(){
        objStr.put("address","29 15th St");
        objStr.put("station","4");

        msg = requestController.deleteFireStation(objStr.toJSONString());

        assertEquals("700",msg);
    }

    @Test
    @Order(7)
    public void createMedicalRecordTest(){
        objStr.put("firstName","Jacques");
        objStr.put("lastName","Flamme");
        objStr.put("birthdate","07/26/1989");
        objStr.put("medications",new JSONArray());
        objStr.put("allergies", new JSONArray());

        msg = requestController.createMedicalRecord(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(8)
    public void updateMedicalRecordTest(){
        arrStr.add("saumon");
        objStr.put("firstName","Jacques");
        objStr.put("lastName","Flamme");
        objStr.put("birthdate","07/26/1989");
        objStr.put("medications",new JSONArray());
        objStr.put("allergies", arrStr);

        msg = requestController.updateMedicalRecords(objStr.toJSONString());

        assertEquals("700",msg);
    }
    @Test
    @Order(9)
    public void deleteMedicalRecordTest(){
        objStr.put("firstName","Jacques");
        objStr.put("lastName","Flamme");

        msg = requestController.deleteMedicalRecords(objStr.toJSONString());

        assertEquals("700",msg);
    }
}

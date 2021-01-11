package com.openclassrooms.safetynetalert.controller;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService ;

    /**End point de /person
     * Create = @PostMapping("/person")
     * Update = @PutMapping("/person")
     * Delete = @DeleteMapping("/person")
     *
     * Etant donné que nous travaillons sur un fichier JSON, les parametres d'entrées seront au format JSON
     **/

    @PostMapping("/person")
    public String createPerson(@RequestBody String person){
        return requestService.createPerson(person) ;
    }
    @PutMapping("/person")
    public String updatePerson(@RequestBody String person){
        return requestService.updatePerson(person) ;
    }
    @DeleteMapping("/person")
    public String deletePerson(@RequestBody String person){
        return requestService.deletePerson(person);
    }
    /**End point de /firestation
     * Create = @PostMapping("/firestation")
     * Update = @PutMapping("/firestation")
     * Delete = @DeleteMapping("/firestation")
     *
     * Etant donné que nous travaillons sur un fichier JSON, les parametres d'entrées seront au format JSON
     **/

    @PostMapping("/firestation")
    public String createFireStation(@RequestBody String fireStation){
        return requestService.createFireStation(fireStation) ;
    }
    @PutMapping("/firestation")
    public String updateFireStation(@RequestBody String fireStation){
        return requestService.updateFireStation(fireStation);
    }
    @DeleteMapping("/firestation")
    public String deleteFireStation(@RequestBody String fireStation){
        return requestService.deleteFireStation(fireStation);
    }

    /**End point de /medicalRecord
     * Create = @PostMapping("/medicalRecord")
     * Update = @PutMapping("/medicalRecord")
     * Delete = @DeleteMapping("/medicalRecord")
     *
     * Etant donné que nous travaillons sur un fichier JSON, les parametres d'entrées seront au format JSON
     **/

    @PostMapping("/medicalRecord")
    public String createMedicalRecord(@RequestBody String medicalRecord){
        return requestService.cretaMedicalRecords(medicalRecord);
    }
    /**Endpoint de PUT /medicalRecord**/
    @PutMapping("/medicalRecord")
    public String updateMedicalRecords(@RequestBody String medicalRecord){
        return requestService.updateMedicalRecords(medicalRecord);
    }

}

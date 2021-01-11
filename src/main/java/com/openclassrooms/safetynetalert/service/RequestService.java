package com.openclassrooms.safetynetalert.service;

import com.openclassrooms.safetynetalert.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository ;

    /**Endpoint de POST /person**/
    public String createPerson(String person){
        return requestRepository.createPerson(person);
    }
    /**Endpoint de PUT /person**/
    public String updatePerson(String person){
        return requestRepository.updatePerson(person) ;
    }
    /**Endpoint de DELETE /person**/
    public String deletePerson(String person){
        return requestRepository.deletePerson(person);
    }

    /**Endpoint de POST /firestation**/
    public String createFireStation(String fireStation){
        return requestRepository.createFireStation(fireStation) ;
    }
    /**Endpoint de PUT /firestation**/
    public String updateFireStation(String fireStation){
        return requestRepository.updateFireStation(fireStation);
    }
    /**Endpoint de DELETE /firestation**/
    public String deleteFireStation(String fireStation){
        return requestRepository.deleteFireStation(fireStation);
    }

    /**Endpoint de POST /medicalRecord**/
    public String cretaMedicalRecords(String medicalRecords){
        return requestRepository.createMedicalRecords(medicalRecords);
    }
    /**Endpoint de PUT /medicalRecord**/
    public String updateMedicalRecords(String medicalRecord){
        return requestRepository.updateMedicalRecords(medicalRecord);
    }

}

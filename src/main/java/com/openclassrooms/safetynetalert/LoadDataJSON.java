/** LOADDATAJSON
 *
 * Crée le 06/01/2021
 *
 * Cette classe à pour rôle de charger les données contenu dans data.json
 * Et de les rentrer dans les classes modeles
 *
 */

package com.openclassrooms.safetynetalert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynetalert.model.FireStations;
import com.openclassrooms.safetynetalert.model.MedicalRecords;
import com.openclassrooms.safetynetalert.model.Persons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class LoadDataJSON {

    @Autowired
    private Persons mPersons ; /** Le m indique qu'on cherche la classe Persons dans le modele**/
    @Autowired
    private FireStations mFireStations ; /** Le m indique qu'on cherche la classe FireStations dans le modele**/
    @Autowired
    private MedicalRecords mMedicalRecords ; /** Le m indique qu'on cherche la classe MedicalRecords dans le modele**/

    public Object loadJsonFile(String url){
        try{
            JSONParser jsonParser = new JSONParser();
            ObjectMapper objectMapper = new ObjectMapper() ;

            Object obj = jsonParser.parse(new FileReader(url));

            return obj ;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null ;
    }
    /**Charge les données de l'Array Persons dans une classe Persons**/
    public boolean loadPersons(String url){

        resetArrayPersons();

        Object obj = loadJsonFile(url);
        JSONObject jsonObject = (JSONObject) obj ;
        JSONArray persons = (JSONArray) jsonObject.get("persons");

        for(int i = 0 ; i < persons.size() ; i++){
            JSONObject persons0 = (JSONObject) persons.get(i);
            String firstNameKey = (String) persons0.get("firstName");
            String lastNameKey = (String) persons0.get("lastName");
            String addressKey = (String) persons0.get("address");
            String cityKey = (String) persons0.get("city");
            String zipKey = (String) persons0.get("zip");
            String phoneKey = (String) persons0.get("phone");
            String emailKey = (String) persons0.get("email");
            mPersons.getFirstName().add(firstNameKey);
            mPersons.getLastName().add(lastNameKey);
            mPersons.getAddress().add(addressKey);
            mPersons.getCity().add(cityKey);
            mPersons.getZip().add(zipKey);
            mPersons.getPhone().add(phoneKey);
            mPersons.getEmail().add(emailKey);
        }

        return true ;
    }
    /**Charge les données de l'Array firestations dans une classe firestations**/
    public boolean loadFireStations(String url){

        resetArrayFireStation();

        Object obj = loadJsonFile(url);
        JSONObject jsonObject = (JSONObject) obj ;
        JSONArray fireStations = (JSONArray) jsonObject.get("firestations");

        for(int i = 0 ; i < fireStations.size() ; i++){
            JSONObject fireStations0 = (JSONObject) fireStations.get(i);
            String addressKey = (String) fireStations0.get("address");
            String stationKey = (String) fireStations0.get("station");
            mFireStations.getAddress().add(addressKey);
            mFireStations.getStation().add(stationKey);
        }

        return true ;
    }
    /**Charge les données de l'Array medicalrecord dans une classe firestations**/
    public boolean loadMedicalRecords(String url){

        resetArrayMedicalRecord();

        Object obj = loadJsonFile(url);
        JSONObject jsonObject = (JSONObject) obj ;
        JSONArray medicalRecords = (JSONArray) jsonObject.get("medicalrecords");
        JSONArray medicationsKey = new JSONArray();
        JSONArray allergiesKey = new JSONArray() ;

        for(int i = 0 ; i < medicalRecords.size() ; i++){
            JSONObject medicalRecord0 = (JSONObject) medicalRecords.get(i);
            String firstNameKey = (String) medicalRecord0.get("firstName");
            String lastNameKey = (String) medicalRecord0.get("lastName");
            String birthdateKey = (String) medicalRecord0.get("birthdate");
            if(medicalRecord0.get("medications").toString().equals("[]") || medicalRecord0.get("allergies").toString().equals("[]")){
                medicationsKey = (JSONArray) medicalRecord0.get("medications");
                allergiesKey = (JSONArray) medicalRecord0.get("allergies");
            }
            else {
                medicationsKey = (JSONArray) medicalRecord0.get("medications");
                allergiesKey = (JSONArray) medicalRecord0.get("allergies");
            }
            mMedicalRecords.getMedications().add(medicationsKey);
            mMedicalRecords.getAllergies().add(allergiesKey);
            mMedicalRecords.getFirstName().add(firstNameKey);
            mMedicalRecords.getLastName().add(lastNameKey);
            mMedicalRecords.getBirthdate().add(birthdateKey);


        }

        return true ;
    }

    /**Remise à zéro des Arrays dans les classe Persons / FireStations / MedicalRecord**/
    public void resetArrayPersons(){
        mPersons.setFirstName(new JSONArray());
        mPersons.setLastName(new JSONArray());
        mPersons.setAddress(new JSONArray());
        mPersons.setCity(new JSONArray());
        mPersons.setZip(new JSONArray());
        mPersons.setPhone(new JSONArray());
        mPersons.setEmail(new JSONArray());
    }

    public void resetArrayFireStation(){
        mFireStations.setAddress(new JSONArray());
        mFireStations.setStation(new JSONArray());
    }

    public void resetArrayMedicalRecord(){
        mMedicalRecords.setFirstName(new JSONArray());
        mMedicalRecords.setLastName(new JSONArray());
        mMedicalRecords.setBirthdate(new JSONArray());
        mMedicalRecords.setMedications(new JSONArray());
        mMedicalRecords.setAllergies(new JSONArray());
    }

}

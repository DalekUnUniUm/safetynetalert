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

    public Object loadJsonFile(){
        try{
            JSONParser jsonParser = new JSONParser();
            ObjectMapper objectMapper = new ObjectMapper() ;

            Object obj = jsonParser.parse(new FileReader("C:/Users/Romuald/Desktop/Exercice OCR/Developpement d'application java/Projet 5/safetynetalert/src/main/resources/data.json"));

            return obj ;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null ;
    }
    /**Charge les données de l'Array Persons dans une classe Persons**/
    public void loadPersons(){
        Object obj = loadJsonFile();
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
    }
    /**Charge les données de l'Array firestations dans une classe firestations**/
    public void loadFireStations(){
        Object obj = loadJsonFile();
        JSONObject jsonObject = (JSONObject) obj ;
        JSONArray fireStations = (JSONArray) jsonObject.get("firestations");

        for(int i = 0 ; i < fireStations.size() ; i++){
            JSONObject fireStations0 = (JSONObject) fireStations.get(i);
            String addressKey = (String) fireStations0.get("address");
            String stationKey = (String) fireStations0.get("station");
            mFireStations.getAddress().add(addressKey);
            mFireStations.getStation().add(stationKey);
        }
    }
    public void loadMedicalRecords(){
        Object obj = loadJsonFile();
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
    }
}

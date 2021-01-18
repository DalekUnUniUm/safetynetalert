package com.openclassrooms.safetynetalert.repository;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.SaveDataJSON;
import com.openclassrooms.safetynetalert.config.UrlFileReader;
import com.openclassrooms.safetynetalert.model.FireStations;
import com.openclassrooms.safetynetalert.model.MedicalRecords;
import com.openclassrooms.safetynetalert.model.Persons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository {

    @Autowired
    private SaveDataJSON saveDataJSON;
    @Autowired
    private Persons mPersons ;
    @Autowired
    private FireStations mFireStations ;
    @Autowired
    private MedicalRecords mMedicalRecords ;
    @Autowired
    private UrlFileReader urlFileReader ;

    private JSONObject jsonObject ;
    private int index ;
    private String statusCode ;

    /**Endpoint de POST /person**/
    public String createPerson(String person){

        statusCode = "700" ;
        jsonObject= new JSONObject();
        jsonObject = converteStrJSon(person);

        mPersons.getFirstName().add(jsonObject.get("firstName"));
        mPersons.getLastName().add(jsonObject.get("lastName"));
        mPersons.getAddress().add(jsonObject.get("address"));
        mPersons.getCity().add(jsonObject.get("city"));
        mPersons.getZip().add(jsonObject.get("zip"));
        mPersons.getPhone().add(jsonObject.get("phone"));
        mPersons.getEmail().add(jsonObject.get("email"));

        saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }
    /**Endpoint de PUT /person**/
    public String updatePerson(String person){
        statusCode = "704" ;
        jsonObject = converteStrJSon(person);

        index = -1 ;

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getFirstName().get(i).equals(jsonObject.get("firstName")) && mPersons.getLastName().get(i).equals(jsonObject.get("lastName"))){
                statusCode = "700" ;
                index = i ;

            }
        }
        if(index != -1){
            mPersons.getFirstName().remove(index);
            mPersons.getFirstName().add(jsonObject.get("firstName"));

            mPersons.getLastName().remove(index);
            mPersons.getLastName().add(jsonObject.get("lastName"));

            mPersons.getAddress().remove(index);
            mPersons.getAddress().add(jsonObject.get("address"));

            mPersons.getCity().remove(index);
            mPersons.getCity().add(jsonObject.get("city"));

            mPersons.getZip().remove(index);
            mPersons.getZip().add(jsonObject.get("zip"));

            mPersons.getPhone().remove(index);
            mPersons.getPhone().add(jsonObject.get("phone"));

            mPersons.getEmail().remove(index);
            mPersons.getEmail().add(jsonObject.get("email"));

            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode" + statusCode);
        return statusCode ;
    }
    /**Endpoint de DELETE /person**/
    public String deletePerson(String person){
        statusCode = "704" ;
        jsonObject = converteStrJSon(person);
        index = -1 ;

        for(int i = 0 ; i < mPersons.getFirstName().size() ; i++){
            if(mPersons.getFirstName().get(i).equals(jsonObject.get("firstName")) && mPersons.getLastName().get(i).equals(jsonObject.get("lastName"))){
                statusCode = "700" ;
                index = i ;
            }
        }

        if(index != -1){
            mPersons.getFirstName().remove(index);
            mPersons.getLastName().remove(index);
            mPersons.getAddress().remove(index);
            mPersons.getZip().remove(index);
            mPersons.getCity().remove(index);
            mPersons.getPhone().remove(index);
            mPersons.getEmail().remove(index);
            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }

    /**Endpoint de POST /firestation**/
    public String createFireStation(String fireStation){
        statusCode = "700" ;

        jsonObject = new JSONObject();
        jsonObject = converteStrJSon(fireStation);

        mFireStations.getAddress().add(jsonObject.get("address"));
        mFireStations.getStation().add(jsonObject.get("station"));

        saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }
    /**Endpoint de PUT /firestation**/
    public String updateFireStation(String fireStation){
        statusCode = "704" ;
        jsonObject = converteStrJSon(fireStation) ;

        index = -1 ;

        for(int i = 0 ; i < mFireStations.getAddress().size() ; i++){
            if(mFireStations.getAddress().get(i).equals(jsonObject.get("address"))){
                statusCode = "700" ;
                index = i ;
            }
        }
        System.out.println("index = " + index);
        if(index != -1){
            mFireStations.getAddress().remove(index);
            mFireStations.getAddress().add(jsonObject.get("address"));

            mFireStations.getStation().remove(index);
            mFireStations.getStation().add(jsonObject.get("station"));

            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }
    /**Endpoint de DELETE /firestation**/
    public String deleteFireStation(String fireStation){
        statusCode = "704" ;
        jsonObject = converteStrJSon(fireStation) ;
        index = -1 ;

        for(int i = 0 ; i < mFireStations.getAddress().size() ; i++){
            if(mFireStations.getAddress().get(i).equals(jsonObject.get("address")) && mFireStations.getStation().get(i).equals(jsonObject.get("station"))){
                statusCode = "700" ;
                index = i ;
            }
        }

        if(index != -1){
            mFireStations.getAddress().remove(index);
            mFireStations.getStation().remove(index);
            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode: " + statusCode);

        return statusCode ;
    }

    /**Endpoint de POST /medicalRecord**/
    public String createMedicalRecords(String medicalRecord){
        statusCode = "700" ;

        jsonObject = new JSONObject();
        jsonObject = converteStrJSon(medicalRecord);

        mMedicalRecords.getFirstName().add(jsonObject.get("firstName"));
        mMedicalRecords.getLastName().add(jsonObject.get("lastName"));
        mMedicalRecords.getBirthdate().add(jsonObject.get("birthdate"));
        mMedicalRecords.getMedications().add(jsonObject.get("medications"));
        mMedicalRecords.getAllergies().add(jsonObject.get("allergies"));

        saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }
    /**Endpoint de PUT /medicalRecord**/
    public String updateMedicalRecords(String medicalRecord){
        statusCode = "704" ;
        jsonObject = converteStrJSon(medicalRecord);
        index = -1 ;

        for(int i = 0 ; i < mMedicalRecords.getFirstName().size() ; i++){
            if(mMedicalRecords.getFirstName().get(i).equals(jsonObject.get("firstName")) && mMedicalRecords.getLastName().get(i).equals(jsonObject.get("lastName"))){
                statusCode = "700" ;
                index = i ;
            }
        }
        if(index != -1){
            mMedicalRecords.getFirstName().remove(index);
            mMedicalRecords.getFirstName().add(jsonObject.get("firstName"));
            mMedicalRecords.getLastName().remove(index);
            mMedicalRecords.getLastName().add(jsonObject.get("lastName"));
            mMedicalRecords.getBirthdate().remove(index);
            mMedicalRecords.getBirthdate().add(jsonObject.get("birthdate"));
            mMedicalRecords.getAllergies().remove(index);
            mMedicalRecords.getAllergies().add(jsonObject.get("allergies"));
            mMedicalRecords.getMedications().remove(index);
            mMedicalRecords.getMedications().add(jsonObject.get("medications"));

            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }
    /**Endpoint de DELETE /medicalRecord**/
    public String deleteMedicalRecords(String medicalRecord){
        statusCode = "704" ;
        jsonObject = converteStrJSon(medicalRecord);
        index = -1 ;

        for(int i = 0 ; i < mMedicalRecords.getFirstName().size() ; i++){
            if(mMedicalRecords.getFirstName().get(i).equals(jsonObject.get("firstName")) && mMedicalRecords.getLastName().get(i).equals(jsonObject.get("lastName"))){
                statusCode = "700" ;
                index = i ;
            }
        }

        if(index != -1){
            mMedicalRecords.getFirstName().remove(index);
            mMedicalRecords.getLastName().remove(index);
            mMedicalRecords.getBirthdate().remove(index);
            mMedicalRecords.getMedications().remove(index);
            mMedicalRecords.getAllergies().remove(index);

            saveDataJSON.saveDataJson(urlFileReader.urlDataJSON());
        }
        Logger.info("statusCode: " + statusCode);
        return statusCode ;
    }

    /**Convertis string en format JSON**/
    private JSONObject converteStrJSon(String strJson){

        JSONParser jsonParser = new JSONParser();
        JSONObject strJSon = new JSONObject();

        try {
            Object obj = jsonParser.parse(strJson);
            strJSon = (JSONObject) obj ;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return strJSon ;
    }

}

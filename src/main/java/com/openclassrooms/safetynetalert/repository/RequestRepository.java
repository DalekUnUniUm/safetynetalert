package com.openclassrooms.safetynetalert.repository;

import com.openclassrooms.safetynetalert.LoadDataJSON;
import com.openclassrooms.safetynetalert.SaveDataJSON;
import com.openclassrooms.safetynetalert.model.FireStations;
import com.openclassrooms.safetynetalert.model.MedicalRecords;
import com.openclassrooms.safetynetalert.model.Persons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    private JSONObject jsonObject ;
    private int index ;
    private String msg ;

    /**Endpoint de POST /person**/
    public String createPerson(String person){

        msg = "Personne enregistré avec succés" ;
        jsonObject= new JSONObject();
        jsonObject = converteStrJSon(person);

        mPersons.getFirstName().add(jsonObject.get("firstName"));
        mPersons.getLastName().add(jsonObject.get("lastName"));
        mPersons.getAddress().add(jsonObject.get("address"));
        mPersons.getCity().add(jsonObject.get("city"));
        mPersons.getZip().add(jsonObject.get("zip"));
        mPersons.getPhone().add(jsonObject.get("phone"));
        mPersons.getEmail().add(jsonObject.get("email"));

        saveDataJSON.saveDataJson();

        return msg ;
    }
    /**Endpoint de PUT /person**/
    public String updatePerson(String person){
        msg = "La personne n'existe pas" ;
        jsonObject = converteStrJSon(person);

        index = -1 ;

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getFirstName().get(i).equals(jsonObject.get("firstName")) && mPersons.getLastName().get(i).equals(jsonObject.get("lastName"))){
                msg = "Modification effectué" ;
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

            saveDataJSON.saveDataJson();
        }

        return msg ;
    }
    /**Endpoint de DELETE /person**/
    public String deletePerson(String person){
        msg = "Cette personne n'existe pas" ;
        jsonObject = converteStrJSon(person);
        index = -1 ;

        for(int i = 0 ; i < mPersons.getFirstName().size() ; i++){
            if(mPersons.getFirstName().get(i).equals(jsonObject.get("firstName")) && mPersons.getLastName().get(i).equals(jsonObject.get("lastName"))){
                msg = "Suppresion effectué" ;
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
            saveDataJSON.saveDataJson();
        }

        return msg ;
    }

    /**Endpoint de POST /firestation**/
    public String createFireStation(String fireStation){
        msg = "Caserne ajoutée avec succés" ;

        jsonObject = new JSONObject();
        jsonObject = converteStrJSon(fireStation);

        mFireStations.getAddress().add(jsonObject.get("address"));
        mFireStations.getStation().add(jsonObject.get("station"));

        saveDataJSON.saveDataJson();

        return msg ;
    }
    /**Endpoint de PUT /firestation**/
    public String updateFireStation(String fireStation){
        msg = "Cette station n'existe pas" ;
        jsonObject = converteStrJSon(fireStation) ;

        index = -1 ;

        for(int i = 0 ; i < mFireStations.getAddress().size() ; i++){
            if(mFireStations.getAddress().get(i).equals(jsonObject.get("address"))){
                msg = "Modification effectué" ;
                index = i ;
            }
        }
        System.out.println("index = " + index);
        if(index != -1){
            mFireStations.getAddress().remove(index);
            mFireStations.getAddress().add(jsonObject.get("address"));

            mFireStations.getStation().remove(index);
            mFireStations.getStation().add(jsonObject.get("station"));

            saveDataJSON.saveDataJson();
        }

        return msg ;
    }
    /**Endpoint de DELETE /firestation**/
    public String deleteFireStation(String fireStation){
        msg = "Cette station n'existe pas" ;
        jsonObject = converteStrJSon(fireStation) ;
        index = -1 ;

        for(int i = 0 ; i < mFireStations.getAddress().size() ; i++){
            if(mFireStations.getAddress().get(i).equals(jsonObject.get("address")) && mFireStations.getStation().get(i).equals("station")){
                msg = "Suppresion effectué" ;
                index = i ;
            }
        }

        if(index != -1){
            mFireStations.getStation().remove(index);
            mFireStations.getAddress().remove(index);
            saveDataJSON.saveDataJson();
        }
        return msg ;
    }

    /**Endpoint de POST /medicalRecord**/
    public String createMedicalRecords(String medicalRecord){
        msg = "Antécédant médicaux enregistré avec succés" ;

        jsonObject = new JSONObject();
        jsonObject = converteStrJSon(medicalRecord);

        mMedicalRecords.getFirstName().add(jsonObject.get("firstName"));
        mMedicalRecords.getLastName().add(jsonObject.get("lastName"));
        mMedicalRecords.getBirthdate().add(jsonObject.get("birthdate"));
        mMedicalRecords.getMedications().add(jsonObject.get("medications"));
        mMedicalRecords.getAllergies().add(jsonObject.get("allergies"));

        saveDataJSON.saveDataJson();

        return msg ;
    }
    /**Endpoint de PUT /medicalRecord**/
    public String updateMedicalRecords(String medicalRecord){
        msg = "Cette personne n'existe pas" ;
        jsonObject = converteStrJSon(medicalRecord);
        index = -1 ;

        for(int i = 0 ; i < mMedicalRecords.getFirstName().size() ; i++){
            if(mMedicalRecords.getFirstName().get(i).equals(jsonObject.get("firstName")) && mMedicalRecords.getLastName().get(i).equals(jsonObject.get("lastName"))){
                msg = "Modification effectué" ;
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

            saveDataJSON.saveDataJson();
        }

        return msg ;
    }
    /**Endpoint de DELETE /medicalRecord**/
    public String deleteMedicalRecords(String medicalRecord){
        msg = "Cette personne n'existe pas" ;
        jsonObject = converteStrJSon(medicalRecord);
        index = -1 ;

        for(int i = 0 ; i < mMedicalRecords.getFirstName().size() ; i++){
            if(mMedicalRecords.getFirstName().get(i).equals(jsonObject.get("firstName")) && mMedicalRecords.getLastName().get(i).equals(jsonObject.get("lastName"))){
                msg = "Suppresion effectué" ;
                index = i ;
            }
        }

        if(index != -1){
            mMedicalRecords.getFirstName().remove(index);
            mMedicalRecords.getLastName().remove(index);
            mMedicalRecords.getBirthdate().remove(index);
            mMedicalRecords.getMedications().remove(index);
            mMedicalRecords.getAllergies().remove(index);

            saveDataJSON.saveDataJson();
        }

        return msg ;
    }

    /**Convertis string en format JSON**/
    public JSONObject converteStrJSon(String strJson){

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

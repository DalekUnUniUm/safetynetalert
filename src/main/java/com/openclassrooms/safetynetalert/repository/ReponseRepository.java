package com.openclassrooms.safetynetalert.repository;

import com.openclassrooms.safetynetalert.model.FireStations;
import com.openclassrooms.safetynetalert.model.MedicalRecords;
import com.openclassrooms.safetynetalert.model.Persons;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import org.pmw.tinylog.Logger;

@Repository
public class ReponseRepository {

    @Autowired
    private FireStations mFireStations ;
    @Autowired
    private Persons mPersons ;
    @Autowired
    private MedicalRecords mMedicalRecords ;

    private LocalDate currentDate ;
    private final DateTimeFormatter MY_PATTERN = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private JSONArray address ;
    private JSONObject obj = new JSONObject();

    /**Endpoint de firestation?stationNumber=<station_number**/
    public JSONArray personByStation(String station_number){
        address = new JSONArray();
        JSONArray personsByStation = new JSONArray();
        int nbrAdulte = 0 ;
        int nbrEnfant = 0 ;

        address = addressFromNumberStation(station_number);

        for(int i = 0 ; i < mPersons.getFirstName().size() ; i++){
            for(int j = 0 ; j < address.size() ; j++){
                if(mPersons.getAddress().get(i).equals(address.get(j))){
                    obj = new JSONObject();
                    obj.put("firstName", mPersons.getFirstName().get(i));
                    obj.put("lastName", mPersons.getLastName().get(i));
                    obj.put("address",mPersons.getAddress().get(i));
                    obj.put("phone",mPersons.getPhone().get(i));
                    if(agePersons(""+mMedicalRecords.getBirthdate().get(i)) <= 18)
                        nbrEnfant++ ;
                    else if(agePersons(""+mMedicalRecords.getBirthdate().get(i)) > 18)
                        nbrAdulte++ ;

                    personsByStation.add(obj);
                }
            }
        }
        personsByStation.add("Nombre(s) mineur(s) = " + nbrEnfant);
        personsByStation.add("Nombre(s) adulte(s) = " + nbrAdulte);

        Logger.info("personsByStation: " + personsByStation);


        return personsByStation ;
    }
    /**Endpoint de childAlert?address=<address>**/
    public JSONArray childrenByAddress(String address){

        JSONArray childByAddress = new JSONArray();
        JSONArray listFamilly = new JSONArray();
        int checkChild = 0 ;

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getAddress().get(i).equals(address)){
                if(agePersons(""+mMedicalRecords.getBirthdate().get(i)) <= 18){
                    checkChild = 1 ;
                    obj = new JSONObject();
                    obj.put("lastName", mPersons.getLastName().get(i));
                    obj.put("firstName", mPersons.getFirstName().get(i));
                    obj.put("age", agePersons(""+ mMedicalRecords.getBirthdate().get(i)));
                    childByAddress.add(obj);
                }

            }
        }
        if(checkChild == 1){
            for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
                if(mPersons.getAddress().get(i).equals(address)){
                    listFamilly.add("firstName: " + mPersons.getFirstName().get(i));
                    listFamilly.add("lastName: "+mPersons.getLastName().get(i));
                }

            }
            childByAddress.add(listFamilly);
        }
        Logger.info("childByAddress: " + childByAddress);
        return childByAddress ;
    }
    /**Endpoint de phoneAlert?firestation=<firestation_number>**/
    public JSONArray phoneByStation(String firestation_number){

        JSONArray phoneByStation = new JSONArray();
        address = new JSONArray();

        address = addressFromNumberStation(firestation_number);

        for(int i = 0 ; i < mPersons.getAddress().size();i++){
            for(int j = 0 ; j < address.size(); j++){
                if(mPersons.getAddress().get(i).equals(address.get(j))){
                    obj = new JSONObject();
                    obj.put("phone",mPersons.getPhone().get(i));
                    phoneByStation.add(obj);

                }
            }

        }
        Logger.info("phoneByStation: " + phoneByStation);

        return phoneByStation ;
    }
    /**Endpoint de fire?address=<address>**/
    public JSONArray personsByAddress(String address){
        JSONArray personByAddress = new JSONArray();
        obj = new JSONObject();

        obj.put("Station",numberStationFromAddress(address));
        personByAddress.add(obj);

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getAddress().get(i).equals(address)){
                obj = new JSONObject();
                obj.put("lastName", mPersons.getLastName().get(i));
                obj.put("phone", mPersons.getPhone().get(i));
                obj.put("age ", agePersons(""+mMedicalRecords.getBirthdate().get(i)));
                obj.put("medicament", mMedicalRecords.getMedications().get(i));
                obj.put("allergies", mMedicalRecords.getAllergies().get(i));
                personByAddress.add(obj);
            }
        }
        Logger.info("personByAddress: " + personByAddress);

        return personByAddress ;
    }
    /**Endpoint de flood/stations?stations=<a list of station_number>**/
    public JSONArray famillyByAddress(String stations){
        JSONArray famillyByAddress = new JSONArray();
        address = addressFromNumberStation(stations);

        for(int i = 0 ; i < address.size() ; i++){
            obj = new JSONObject();
            obj.put("address" , address.get(i));
            famillyByAddress.add(obj);
            for(int j = 0 ; j < mPersons.getAddress().size() ; j++){
                if(mPersons.getAddress().get(j).equals(address.get(i))){
                    obj = new JSONObject();
                    obj.put("lastName", mPersons.getLastName().get(j));
                    obj.put("phone", mPersons.getPhone().get(j));
                    obj.put("age", agePersons(""+mMedicalRecords.getBirthdate().get(j)));
                    obj.put("medicament", mMedicalRecords.getMedications().get(j));
                    obj.put("allergies", mMedicalRecords.getAllergies().get(j));
                    famillyByAddress.add(obj);
                }
            }
        }
        Logger.info("famillyByAddress: " + famillyByAddress);

        return famillyByAddress ;
    }
    /**Endpont de personInfo?firstName=<firstName>&lastName=<lastName>**/
    public JSONArray personsInfoByName(String firstName , String lastName){
        JSONArray personInfoByName = new JSONArray();

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getFirstName().get(i).equals(firstName) && mPersons.getLastName().get(i).equals(lastName)){
                obj = new JSONObject();
                obj.put("lastName", mPersons.getLastName().get(i));
                obj.put("address", mPersons.getAddress().get(i));
                obj.put("age", agePersons(""+mMedicalRecords.getBirthdate().get(i)));
                obj.put("medicament", mMedicalRecords.getMedications().get(i));
                obj.put("allergies", mMedicalRecords.getAllergies().get(i));
                personInfoByName.add(obj);

            }
        }
        Logger.info("personsInfoByName: " + personInfoByName);
        return personInfoByName ;

    }
    /**Endpoint de communityEmail?city=<city>**/
    public JSONArray emailByCity(String city){
        JSONArray emailByCity = new JSONArray();

        for(int i = 0 ; i < mPersons.getAddress().size() ; i++){
            if(mPersons.getCity().get(i).equals(city)){
                obj = new JSONObject();
                obj.put("email",mPersons.getEmail().get(i));
                emailByCity.add(obj);
            }
        }
        Logger.info("emailByCity: " + city);
        return emailByCity ;
    }

    /**Permet de calculer l'age des personnes**/
    private int agePersons(String birthDateStr){
        Logger.debug("agePersons: " + birthDateStr);
        int age = 0 ;

        LocalDate birthDate = LocalDate.parse("" + birthDateStr, MY_PATTERN);
        currentDate = LocalDate.now();
        age = Period.between(birthDate,currentDate).getYears();
        Logger.debug("age: " + age);
        return age ;
    }
    /**Chercher une liste d'adresse par rapport au numéro de station**/
    private JSONArray addressFromNumberStation(String station_number){
        Logger.debug("addressFromNumberStation: " + station_number);
        JSONArray addressFromNumberSt = new JSONArray();
        for(int i = 0 ; i < mFireStations.getStation().size() ; i++){
            if(mFireStations.getStation().get(i).equals(station_number)){
                addressFromNumberSt.add(mFireStations.getAddress().get(i));
            }
        }
        Logger.debug("addressFromNumberSt: " + addressFromNumberSt);
        return addressFromNumberSt ;
    }
    /**Chercher le numéro de caserne en fonction de l'adresse**/
    private String numberStationFromAddress(String address){
        Logger.debug("numberStationFromAddress: " + address);
        String numberStationFrAd = "" ;

        for(int i = 0 ; i < mFireStations.getAddress().size() ; i++){
            if(mFireStations.getAddress().get(i).equals(address)){
                numberStationFrAd = ""+mFireStations.getStation().get(i);
            }
        }
        Logger.debug("numberStationFrAd: " + numberStationFrAd);
        return numberStationFrAd ;

    }

}

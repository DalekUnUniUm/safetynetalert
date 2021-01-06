package com.openclassrooms.safetynetalert.repository;

import com.openclassrooms.safetynetalert.model.FireStations;
import com.openclassrooms.safetynetalert.model.Persons;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReponseRepository {

    @Autowired
    private FireStations mFireStations ;

    @Autowired
    private Persons mPersons ;

    public JSONArray personByStation(String station_number){

        JSONArray address = new JSONArray();

        JSONArray firstName = new JSONArray();
        JSONArray lastName = new JSONArray();
        JSONArray addressTemp = new JSONArray();
        JSONArray phone = new JSONArray();

        JSONArray personsByStation = new JSONArray();

        for(int i = 0 ; i < mFireStations.getStation().size() ; i++){
            if(mFireStations.getStation().get(i).equals(station_number)){
                //System.out.println("index = " + i + " address = " + mFireStations.getAddress().get(i));
                address.add(mFireStations.getAddress().get(i));
            }
        }
        /**Si la station existe elle retourne une adresse donc rempli le tableau, sinon il est vide et on renvoie un
         * message d'erreur
         */
        if(address.size() == 0){
            personsByStation.add("Cette station n'est pas dans notre base de données") ;
        }
        else{
            for(int i = 0 ; i < mPersons.getFirstName().size() ; i++){
                for(int j = 0 ; j < address.size() ; j++){
                    if(mPersons.getAddress().get(i).equals(address.get(j))){
                        firstName.add("firstName:");
                        firstName.add(mPersons.getFirstName().get(i));
                        lastName.add("lastName:");
                        lastName.add(mPersons.getLastName().get(i));
                        address.add("address:");
                        addressTemp.add(mPersons.getAddress().get(i));
                        phone.add("phone:");
                        phone.add(mPersons.getPhone().get(i));
                    }
                }

            }
        }
        personsByStation.add(firstName);
        personsByStation.add(lastName);
        personsByStation.add(addressTemp);
        personsByStation.add(phone);

        System.out.println(personsByStation);

        return personsByStation ;
    }

}

package com.openclassrooms.safetynetalert.model;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecords {

    private JSONArray firstName = new JSONArray();
    private JSONArray lastName = new JSONArray();
    private JSONArray birthdate = new JSONArray();
    private JSONArray medications = new JSONArray();
    private JSONArray allergies = new JSONArray();

    public JSONArray getFirstName() {
        return firstName;
    }

    public void setFirstName(JSONArray firstName) {
        this.firstName = firstName;
    }

    public JSONArray getLastName() {
        return lastName;
    }

    public void setLastName(JSONArray lastName) {
        this.lastName = lastName;
    }

    public JSONArray getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(JSONArray birthdate) {
        this.birthdate = birthdate;
    }

    public JSONArray getMedications() {
        return medications;
    }

    public void setMedications(JSONArray medications) {
        this.medications = medications;
    }

    public JSONArray getAllergies() {
        return allergies;
    }

    public void setAllergies(JSONArray allergies) {
        this.allergies = allergies;
    }
}

package com.openclassrooms.safetynetalert.model;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class Persons {

    private JSONArray firstName = new JSONArray() ;
    private JSONArray lastName = new JSONArray() ;
    private JSONArray address = new JSONArray() ;
    private JSONArray city = new JSONArray() ;
    private JSONArray zip = new JSONArray() ;
    private JSONArray phone = new JSONArray() ;
    private JSONArray email = new JSONArray() ;

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

    public JSONArray getAddress() {
        return address;
    }

    public void setAddress(JSONArray address) {
        this.address = address;
    }

    public JSONArray getCity() {
        return city;
    }

    public void setCity(JSONArray city) {
        this.city = city;
    }

    public JSONArray getZip() {
        return zip;
    }

    public void setZip(JSONArray zip) {
        this.zip = zip;
    }

    public JSONArray getPhone() {
        return phone;
    }

    public void setPhone(JSONArray phone) {
        this.phone = phone;
    }

    public JSONArray getEmail() {
        return email;
    }

    public void setEmail(JSONArray email) {
        this.email = email;
    }
}

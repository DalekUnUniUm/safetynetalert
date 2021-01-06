package com.openclassrooms.safetynetalert.model;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class FireStations {

    private JSONArray address = new JSONArray();
    private JSONArray station = new JSONArray();

    public JSONArray getAddress() {
        return address;
    }

    public void setAddress(JSONArray address) {
        this.address = address;
    }

    public JSONArray getStation() {
        return station;
    }

    public void setStation(JSONArray station) {
        this.station = station;
    }
}

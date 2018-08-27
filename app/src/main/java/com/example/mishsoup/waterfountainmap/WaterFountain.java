package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

public class WaterFountain {

    LatLng latLng;
    String name;
    String location;
    String operationTime;


    /**
     * Constructor
     * @param latLng         the coordinates of the water fountain
     * @param name           name of the bus
     * @param location       instruction on how to get to the waterfountain
     * @param operationTime   details regarding the operation times of the water fountain
     */

    public WaterFountain (LatLng latLng, String name, String location, String operationTime) {
        this.latLng           = latLng;
        this.name             = name;
        this.location         = location;
        this.operationTime    = operationTime;
    }



}

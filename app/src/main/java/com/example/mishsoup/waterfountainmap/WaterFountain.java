package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import java.util.Objects;

public class WaterFountain {

    private LatLng latLng;
    private String name;
    private String location;
    private String operationTime;


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

    public LatLng getLatLng() {
        return latLng;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getOperationTime() {
        return operationTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterFountain that = (WaterFountain) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

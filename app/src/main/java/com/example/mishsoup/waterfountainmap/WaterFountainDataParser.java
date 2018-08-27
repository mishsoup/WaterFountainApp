package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class WaterFountainDataParser {

public static Collection<WaterFountain> parseWaterFountain()throws JSONException {

    String data = null;
    ArrayList<WaterFountain> waterFountains = new ArrayList<>();


    try {
        InputStream is = new FileInputStream("data/drinking_fountains.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();
        data = sb.toString();

    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Can't read the data");
    }

    JSONArray fountains = new JSONArray(data);



    for (int index = 0; index < fountains.length(); index ++) {
        JSONObject fountain = fountains.getJSONObject(index);
        waterFountains.add(parseFountain(fountain));
    }



    return waterFountains;
}


    public static WaterFountain parseFountain(JSONObject fountain) throws JSONException {

        LatLng latLng = null ;
        String name = null;
        String location = null;
        String operationTime = null;



        JSONObject geometry = fountain.getJSONObject("geometry");
        JSONArray coordinates = geometry.getJSONArray("coordinates");
        latLng = new LatLng(coordinates.getDouble(0), coordinates.getDouble(1));


        JSONObject properties = fountain.getJSONObject("properties");

        if (!properties.isNull("NAME"))
            name = properties.getString("NAME");

        if (!properties.isNull("LOCATION"))
            location = properties.getString("LOCATION");

        if (!properties.isNull("IN_OPERATION"))
            operationTime = properties.getString("IN_OPERATION");




      return new WaterFountain(latLng, name, location, operationTime);




    }

}

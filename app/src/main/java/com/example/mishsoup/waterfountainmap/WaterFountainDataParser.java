package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WaterFountainDataParser {

public static List<WaterFountain> parseWaterFountain() throws IOException {

    List<WaterFountain> fountains = null;

    FileInputStream fstream = new FileInputStream("data/FountainData.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;

//Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
        // parse line by line
        fountains.add(parseOneLine(strLine));
    }

//Close the input stream
    try {
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return fountains;
}


    public static WaterFountain parseOneLine(String str) {

        LatLng latLng = null;
        String name = null;
        String location = null;
        String operationTime = null;


        String array[]= str.split(",");
        latLng = new LatLng(Float.parseFloat(array[1]), Float.parseFloat(array[2]));
        name = array[3];
        location = array[4];
        operationTime = array[6];




      return new WaterFountain(latLng, name, location, operationTime);




    }

}

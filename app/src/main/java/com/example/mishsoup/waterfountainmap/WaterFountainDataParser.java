package com.example.mishsoup.waterfountainmap;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import com.google.android.gms.maps.model.LatLng;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WaterFountainDataParser {

    public static Context context;


public static List<WaterFountain> parseWaterFountain(Activity activity) throws IOException {

    List<WaterFountain> fountains = new ArrayList<>();
    AssetManager assetManager = activity.getAssets();

    InputStream fstream = assetManager.open("FountainData.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));



    String strLine;

//Read File Line By Line
    while ((strLine = br.readLine()) != null) fountains.add(parseOneLine(strLine));

//Close the input stream
    try {
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return fountains;
}


    public static WaterFountain parseOneLine(String str) {

        LatLng latLng;
        String name ;
        String location = "N/A";
        String operationTime = "N/A" ;


        String array[]= str.split(",");

        if (array.length > 6) {
        latLng = new LatLng(Float.parseFloat(array[1]), Float.parseFloat(array[2]));
        name = array[3];
        location = array[4];
        operationTime = array[6];
        } else  {
            latLng = new LatLng(Float.parseFloat(array[1]), Float.parseFloat(array[2]));
            name = array[3];

        }




      return new WaterFountain(latLng, name, location, operationTime);




    }

}

package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

public class WaterFountainDataParser {

public static Collection<WaterFountain> parseWaterFountain()throws JSONException {

    String data = null;


    try {
        InputStream is = new FileInputStream("drinking_fountains.json");
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



    return null;
}

}

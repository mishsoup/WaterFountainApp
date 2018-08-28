package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestParser {


    @Test
    public void testData() {

            try {
                WaterFountainDataParser.parseWaterFountain();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}

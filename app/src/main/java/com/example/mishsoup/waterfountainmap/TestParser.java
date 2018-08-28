package com.example.mishsoup.waterfountainmap;

import com.google.android.gms.maps.model.LatLng;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TestParser {


    @Test
    public void testData() {

        WaterFountain testFountain = new WaterFountain(new LatLng(49.234947000370603,-123.027254000176000),
                "Fountain location:Aberdeen Park",
                "plaza",
                "spring to fall");

            try {
                List<WaterFountain> fountains = WaterFountainDataParser.parseWaterFountain(null);

                if (fountains.contains(testFountain))
                    System.out.println("contains!");


            } catch (IOException e) {
                e.printStackTrace();
            }


        }



}

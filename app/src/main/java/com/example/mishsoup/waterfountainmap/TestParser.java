package com.example.mishsoup.waterfountainmap;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

public class TestParser {

    @Test
    public void testParser() {
        try {
            WaterFountainDataParser.parseWaterFountain();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

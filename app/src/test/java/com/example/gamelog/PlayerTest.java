package com.example.gamelog;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

public class PlayerTest {
    JSONArray arr = convertString("[{\"Name\": \"Kyler Murray\"]}]");
    Player player = new Player(arr, 0);

    public JSONArray convertString(String jsonString){
        JSONArray obj = null;
        try {
            obj = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

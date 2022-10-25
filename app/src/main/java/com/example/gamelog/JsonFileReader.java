package com.example.gamelog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;

public class JsonFileReader {
    String week1Path = "C:\\Users\\drew\\OneDrive\\SeniorProject\\jsononline-net.json";

    public JsonFileReader(){}

    public JSONObject getJSONObject(String path) throws JSONException {
        JSONObject obj = new JSONObject(path);
        return obj;
    }

    public void displayScore(){

    }
}

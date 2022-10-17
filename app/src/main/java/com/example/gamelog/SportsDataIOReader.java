package com.example.gamelog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SportsDataIOReader {
    private String urlString;

    public SportsDataIOReader(String baseUrl, String season, String week, String key){
        try {
            urlString = baseUrl + URLEncoder.encode(season, "UTF-8") + URLEncoder.encode(week, "UTF-8");
            if(key != null) {
                urlString += URLEncoder.encode("?key=", "UTF-8") + key;
            }
        }
        catch(UnsupportedEncodingException uee){
            urlString = "";
        }
    }

    public String getUrlString(){return urlString;}

    public String getSportsData(){
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();

            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String dataRead = new String();
            String line = br.readLine();
            while(line != null){
                dataRead += line;
                line = br.readLine();
            }
            is.close();
            con.disconnect();
            return dataRead;
        } catch(Exception e){
            return "";
        }
    }
}

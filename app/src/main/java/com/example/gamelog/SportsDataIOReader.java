package com.example.gamelog;

import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SportsDataIOReader {
    private String urlString;

    public SportsDataIOReader(String baseUrl, String week, String team, String key){
        urlString = baseUrl + "2022REG/" + week + "/" + team + "?key=" + key;
    }

    public SportsDataIOReader(String baseUrl, String week, String key){
        urlString = baseUrl + "2022REG/" + week + "?key=" + key;
    }



    public String getUrlString(){return urlString;}

    public String getSportsData(){
        try {
            HttpURLConnection con = getHttpURLConnection(urlString);

            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String dataRead = "";
            String line = br.readLine();
            while(line != null){
                dataRead += line;
                line = br.readLine();
            }
            is.close();
            con.disconnect();
            return dataRead;
        } catch(Exception e){
            return e.toString();
        }
    }

    @NonNull
    public HttpURLConnection getHttpURLConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        return con;
    }
}

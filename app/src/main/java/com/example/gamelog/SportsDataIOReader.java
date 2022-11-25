package com.example.gamelog;





import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SportsDataIOReader {
    private String urlString;

    public SportsDataIOReader(String baseUrl, String week, String team, String key){
//        try {
//            urlString = baseUrl + URLEncoder.encode("2022REG/" + week + "/" + team + "/", "UTF-8");
//            if(key != null) {
//                urlString += URLEncoder.encode("?key=" + key, "UTF-8");
//            }
//        }
//        catch(UnsupportedEncodingException uee){
//            urlString = "";
//        }
        urlString = baseUrl + "2022REG/" + week + "/" + team + "?key=" + key;
    }
//    "https://api.sportsdata.io/v3/nfl/stats/json/PlayerGameStatsByTeam/""2022REG/""1""/""ARI""?key=""a3933e1e58d54f1dac244a8dda94b7c4"
//    "https://api.sportsdata.io/v3/nfl/stats/json/PlayerGameStatsByTeam/2022REG/1/ARI?key=a3933e1e58d54f1dac244a8dda94b7c4"


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
    private HttpURLConnection getHttpURLConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        return con;
    }
}

package com.example.gamelog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Activity to retrieve the scores and stats from the api using the SportsDataIOReader class
 * and populate a boxscore using the Player class
 */
public class BoxScore extends AppCompatActivity {

    /**
     * SportsDataIOReader to receive player stat information form the api
     */
    public SportsDataIOReader io;

    /**
     * SportsDataIOReader to receive game score from the api
     */
    public SportsDataIOReader io2;

    /**
     * @param savedInstanceState
     * Initializes io2 to communicate with the api address for scores
     * Starts thread to update score while also reading and writing to the UI
     *
     * Initializes io to communicate with the api address for player stats
     * Starts another thread to update player stats while also reading and writing to the UI
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box_score);
        setIo2("https://api.sportsdata.io/v3/nfl/stats/json/TeamGameStats/",
                getWeekAbbreviation(Schedule.getWeek()));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sportsData = io2.getSportsData();
                int arrSize = 0;
                try {
                    arrSize = new JSONArray(sportsData).length();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int finalArrSize = arrSize;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONArray obj = null;
                        int index = 0;
                        try {
                            obj = new JSONArray(sportsData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < finalArrSize; i++) {
                            try {
                                String team = obj.getJSONObject(i).getString("Team");
                                if (team.equals(getTeamAbbreviation(HomeScreen.getTeam()))){
                                    index = i;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        displayScore(sportsData, index);
                    }
                });
            }
        }).start();
        LinearLayout ll = (LinearLayout) findViewById(R.id.scroll_layout);
        TextView tv = new TextView(this);
        setIo("https://api.sportsdata.io/v3/nfl/stats/json/PlayerGameStatsByTeam/",
                getWeekAbbreviation(Schedule.getWeek()),getTeamAbbreviation(HomeScreen.getTeam()));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sportsData = io.getSportsData();
                int arrSize = 0;
                try {
                    arrSize = new JSONArray(sportsData).length();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int finalArrSize = arrSize;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < finalArrSize; i++) {
                            TextView tv = new TextView(getApplicationContext());
                            tv.setText(getPlayerStats(sportsData, i));
                            ll.addView(tv);
                        }
                    }
                });
            }
        }).start();
    }

    /**
     * @param jsonString String from the json file received from the api, to be turned into a json array
     * @param index int correlating with the index in which the score should be received from in the json array
     * Retrieves the scores at the correct index and puts them in a text view
     */
    public void displayScore(String jsonString, int index) {
        JSONArray obj = null;
        try {
            obj = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String homeScore = null;
        String awayScore = null;
        try {
            homeScore = obj.getJSONObject(index).getString("Score");
            awayScore = obj.getJSONObject(index).getString("OpponentScore");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView home = (TextView) findViewById(R.id.homeScore);
        TextView away = (TextView) findViewById(R.id.awayScore);
        home.setText("Home Score: " + homeScore);
        away.setText("Away Score: " + awayScore);
    }

    /**
     * @param jsonString String from the json file received from the api, to be turned into a json array
     * @param index int correlating with the index in which the stats should be received from in the json array
     * Retrieves the stats at the correct index and puts them in a text view
     * Dynamically writes the stats to the textview for the correct player that is read from the json array
     */
    public String getPlayerStats(String jsonString, int index){
        JSONArray obj = null;
        try {
            obj = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Player player = new Player(obj, index);
        player.setPlayerName();
        try {
            if(obj.getJSONObject(index).getString("Position").equals("QB")){
                player.setPlayerQBStat();
            } else if (obj.getJSONObject(index).getString("Position").equals("TE")) {
                player.setPlayerTEStat();
            } else if (obj.getJSONObject(index).getString("Position").equals("TE")) {
                player.setPlayerTEStat();
            } else if (obj.getJSONObject(index).getString("Position").equals("RB")) {
                player.setPlayerRBStat();
            } else if (obj.getJSONObject(index).getString("PositionCategory").equals("DEF")) {
                player.setPlayerDEFStat();
            } else if (obj.getJSONObject(index).getString("Position").equals("OL")) {
                player.setPlayerOLStat();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return player.getPlayerName() + player.getPlayerStat();
    }


    @NonNull
    private String getStartedString(int index, JSONArray obj, String playerStats,
                                    String s, String s2) throws JSONException {
        if (obj.getJSONObject(index).getString("Started").equals("1")) {
            playerStats = playerStats + s;
        } else {
            playerStats = playerStats + s2;
        }
        return playerStats;
    }

    /**
     * @param teamName Team name passed in from the team selected in the HomeScreen Activity
     * @return The abbreviation that will be used to create the correct url to access the api
     */
    public String getTeamAbbreviation(String teamName){
        switch (teamName){
            case "ARIZONA CARDINALS":
                return "ARI";
            case "ATLANTA FALCONS":
                return "ATL";
            case "BALTIMORE RAVENS":
                return "BAL";
            case "BUFFALO BILLS":
                return "BUF";
            case "CAROLINA PANTHERS":
                return "CAR";
            case "CHICAGO BEARS":
                return "CHI";
            case "CINCINNATI BENGALS":
                return "CIN";
            case "CLEVELAND BROWNS":
                return "CLE";
            case "DALLAS COWBOYS":
                return "DAL";
            case "DENVER BRONCOS":
                return "DEN";
            case "DETROIT LIONS":
                return "DET";
            case "GREEN BAY PACKERS":
                return "GB";
            case "HOUSTON TEXANS":
                return "HOU";
            case "INDIANAPOLIS COLTS":
                return "IND";
            case "JACKSONVILLE JAGUARS":
                return "JAX";
            case "KANSAS CITY CHIEFS":
                return "KC";
            case "LAS VEGAS RAIDERS":
                return "LV";
            case "LOS ANGELES RAMS":
                return "LAR";
            case "LOS ANGELES CHARGERS":
                return "LAC";
            case "MIAMI DOLPHINS":
                return "MIA";
            case "MINNESOTA VIKINGS":
                return "MIN";
            case "NEW ENGLAND PATRIOTS":
                return "NE";
            case "NEW ORLEANS SAINTS":
                return "NO";
            case "NEW YORK GIANTS":
                return "NYG";
            case "NEW YORK JETS":
                return "NYJ";
            case "PHILADELPHIA EAGLES":
                return "PHI";
            case "PITTSBURGH STEELERS":
                return "PIT";
            case "SAN FRANCISCO 49ERS":
                return "SF";
            case "SEATTLE SEAHAWKS":
                return "SEA";
            case "TAMPA BAY BUCCANEERS":
                return "TB";
            case "TENNESSEE TITANS":
                return "TEN";
            case "WASHINGTON COMMANDERS":
                return "WAS";
        }
        return null;
    }

    /**
     * @param week Week passed in from the week selected in the Schedule Activity
     * @return The abbreviation that will be used to create the correct url to access the api
     */
    public String getWeekAbbreviation(String week){
        switch(week){
            case "Week 1":
                return "1";
            case "Week 2":
                return "2";
            case "Week 3":
                return "3";
            case "Week 4":
                return "4";
            case "Week 5":
                return "5";
            case "Week 6":
                return "16";
            case "Week 7":
                return "7";
            case "Week 8":
                return "8";
            case "Week 9":
                return "9";
            case "Week 10":
                return "10";
            case "Week 11":
                return "11";
            case "Week 12":
                return "12";
            case "Week 13":
                return "13";
            case "Week 14":
                return "14";
            case "Week 15":
                return "15";
            case "Week 16":
                return "16";
            case "Week 17":
                return "17";
            case "Week 18":
                return "18";
        }
        return null;
    }

    public SportsDataIOReader getIo() {
        return io;
    }

    public void setIo(String baseUrl, String week, String team) {
        io = new SportsDataIOReader(baseUrl, week, team, getKey());
    }

    public void setIo2(String baseUrl, String week) {
        io2 = new SportsDataIOReader(baseUrl, week, getKey());
    }


    public String getKey(){
        String key = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("key.txt");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            key = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }
}
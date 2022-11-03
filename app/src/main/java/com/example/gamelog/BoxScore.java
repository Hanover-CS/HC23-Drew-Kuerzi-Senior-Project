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

public class BoxScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box_score);
//        In the future instead of just one file it will use the SportsDataIO with the saved team and week to retrieve json file
        displayScore(getApplicationContext(), "arizona1.json", 0);
        LinearLayout ll = (LinearLayout) findViewById(R.id.scroll_layout);
        int arrSize = 0;
        try {
            arrSize = new JSONArray(getJSONString(getApplicationContext(), "arizona1stats.json")).length();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrSize; i++) {
            TextView tv = new TextView(this);
            tv.setText(getPlayerStats(getApplicationContext(), "arizona1stats.json", i));
            ll.addView(tv);
        }
    }

    public String getJSONString(Context context, String filename) throws IOException, JSONException {
        String jsonString = null;
        try {
            InputStream is = context.getAssets().open(filename);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public void displayScore(Context context, String filename, int index) {
        JSONArray obj = null;
        try {
            obj = new JSONArray(getJSONString(context, filename));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public String getPlayerStats(Context context, String filename, int index) {
        JSONArray obj = null;
        try {
            obj = new JSONArray(getJSONString(context, filename));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String playerName = null;
        String playerStats = null;
        try {
            playerName = obj.getJSONObject(index).getString("Name");
            if (obj.getJSONObject(index).getString("Position").equals("QB")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                        + " Pass Attempts: " + obj.getJSONObject(index).getString("PassingAttempts") + "\n"
                        + " Completions: " + obj.getJSONObject(index).getString("PassingCompletions") + "\n"
                        + " Passing Yards: " + obj.getJSONObject(index).getString("PassingYards") + "\n"
                        + " Touchdowns: " + obj.getJSONObject(index).getJSONArray("ScoringDetails").length() + "\n";
                playerStats = getStartedString(index, obj, playerStats, " Started this game \n", " Did not start this game \n");
            } else if (obj.getJSONObject(index).getString("Position").equals("WR")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                        + ": Targets: " + obj.getJSONObject(index).getString("ReceivingTargets") + "\n"
                        + " Receptions: " + obj.getJSONObject(index).getString("Receptions") + "\n"
                        + " Receiving Yards: " + obj.getJSONObject(index).getString("ReceivingYards") + "\n"
                        + " Touchdowns: " + obj.getJSONObject(index).getString("ReceivingTouchdowns") + "\n";
                playerStats = getStartedString(index, obj, playerStats, " Started this game \n", " Did not start this game \n");
            } else if (obj.getJSONObject(index).getString("Position").equals("TE")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                        + ": Targets: " + obj.getJSONObject(index).getString("ReceivingTargets") + "\n"
                        + " Receptions: " + obj.getJSONObject(index).getString("Receptions") + "\n"
                        + " Receiving Yards: " + obj.getJSONObject(index).getString("ReceivingYards") + "\n"
                        + " Touchdowns: " + obj.getJSONObject(index).getString("ReceivingTouchdowns") + "\n";
                playerStats = getStartedString(index, obj, playerStats, " Started this game \n", " Did not start this game \n");
            } else if (obj.getJSONObject(index).getString("Position").equals("RB")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                        + ": Rush Attempts: " + obj.getJSONObject(index).getString("RushingAttempts") + "\n"
                        + " Rushing Yards: " + obj.getJSONObject(index).getString("RushingYards") + "\n"
                        + " Touchdowns: " + obj.getJSONObject(index).getString("RushingTouchdowns") + "\n";
                playerStats = getStartedString(index, obj, playerStats, " Started this game \n", " Did not start this game \n");
            } else if (obj.getJSONObject(index).getString("PositionCategory").equals("DEF")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                        + ": Passes Defended: " + obj.getJSONObject(index).getString("PassesDefended") + "\n"
                        + " Interceptions: " + obj.getJSONObject(index).getString("Interceptions") + "\n"
                        + " Sacks: " + obj.getJSONObject(index).getString("Sacks") + "\n"
                        + " Fumbles Forced: " + obj.getJSONObject(index).getString("FumblesForced") + "\n"
                        + " Solo Tackles: " + obj.getJSONObject(index).getString("SoloTackles") + "\n"
                        + " Assisted Tackles: " + obj.getJSONObject(index).getString("AssistedTackles") + "\n";
                playerStats = getStartedString(index, obj, playerStats, " Started this game \n", " Did not start this game \n");
            } else if (obj.getJSONObject(index).getString("Position").equals("OL")) {
                playerStats = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n";
                playerStats = getStartedString(index, obj, playerStats, ": Started this game \n", ": Did not start this game \n");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return playerName + playerStats;
    }

    @NonNull
    private String getStartedString(int index, JSONArray obj, String playerStats, String s, String s2) throws JSONException {
        if (obj.getJSONObject(index).getString("Started").equals("1")) {
            playerStats = playerStats + s;
        } else {
            playerStats = playerStats + s2;
        }
        return playerStats;
    }
}
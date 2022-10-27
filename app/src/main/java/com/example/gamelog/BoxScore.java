package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
        displayScore(getApplicationContext(), "arizona1.json", 0);
        displayPlayer(getApplicationContext(), "arizona1stats.json", 0);

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

    public void displayScore(Context context, String filename, int index){
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

    public void displayPlayer(Context context, String filename, int index){
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
            if(obj.getJSONObject(index).getString("Position").equals("QB")){
                playerStats = ": Pass Attempts: " + obj.getJSONObject(index).getString("PassingAttempts")
                        + " Completions: " + obj.getJSONObject(index).getString("PassingCompletions")
                        + " Passing Yards: " + obj.getJSONObject(index).getString("PassingYards")
                        + " Touchdowns: " + obj.getJSONObject(index).getJSONArray("ScoringDetails").length();
            }
            else if(obj.getJSONObject(index).getString("Position").equals("WR")){
                playerStats = ": Targets: " + obj.getJSONObject(index).getString("ReceivingTargets")
                        + " Receptions: " + obj.getJSONObject(index).getString("Receptions")
                        + " ReceivingYards: " + obj.getJSONObject(index).getString("ReceivingYards")
                        + " Touchdowns: " + obj.getJSONObject(index).getString("ReceivingTouchdowns");
            }
            else if(obj.getJSONObject(index).getString("Position").equals("RB")){
                playerStats = ": RushAttempts: " + obj.getJSONObject(index).getString("RushingAttempts")
                        + " RushingYards: " + obj.getJSONObject(index).getString("RushingYards")
                        + " Touchdowns: " + obj.getJSONObject(index).getString("RushingTouchdowns");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView player = (TextView) findViewById(R.id.player1);
        player.setText(playerName + playerStats);

    }
}
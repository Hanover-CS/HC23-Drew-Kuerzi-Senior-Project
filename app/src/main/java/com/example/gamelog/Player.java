package com.example.gamelog;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;

public class Player {
    private final JSONArray obj;
    private final int index;
    private String playerName;
    private String playerStat;

    public Player(JSONArray obj, int index){
        this.obj = obj;
        this.index = index;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName() {
        try {
            this.playerName = obj.getJSONObject(index).getString("Name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerStat() {
        return playerStat;
    }

    public void setPlayerQBStat() {
        try {
            this.playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                    + " Pass Attempts: " + obj.getJSONObject(index).getString("PassingAttempts") + "\n"
                    + " Completions: " + obj.getJSONObject(index).getString("PassingCompletions") + "\n"
                    + " Passing Yards: " + obj.getJSONObject(index).getString("PassingYards") + "\n"
                    + " Touchdowns: " + obj.getJSONObject(index).getJSONArray("ScoringDetails").length() + "\n";
            this.playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setPlayerWRStat() {
        try {
            playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                    + ": Targets: " + obj.getJSONObject(index).getString("ReceivingTargets") + "\n"
                    + " Receptions: " + obj.getJSONObject(index).getString("Receptions") + "\n"
                    + " Receiving Yards: " + obj.getJSONObject(index).getString("ReceivingYards") + "\n"
                    + " Touchdowns: " + obj.getJSONObject(index).getString("ReceivingTouchdowns") + "\n";
            playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setPlayerRBStat() {
        try{
            playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                    + ": Rush Attempts: " + obj.getJSONObject(index).getString("RushingAttempts") + "\n"
                    + " Rushing Yards: " + obj.getJSONObject(index).getString("RushingYards") + "\n"
                    + " Touchdowns: " + obj.getJSONObject(index).getString("RushingTouchdowns") + "\n";
            playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
    } catch (JSONException e) {
        e.printStackTrace();
    }
    }

    public void setPlayerTEStat() {
        try{
            playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                    + ": Targets: " + obj.getJSONObject(index).getString("ReceivingTargets") + "\n"
                    + " Receptions: " + obj.getJSONObject(index).getString("Receptions") + "\n"
                    + " Receiving Yards: " + obj.getJSONObject(index).getString("ReceivingYards") + "\n"
                    + " Touchdowns: " + obj.getJSONObject(index).getString("ReceivingTouchdowns") + "\n";
            playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
    } catch (JSONException e) {
        e.printStackTrace();
        }
    }

    public void setPlayerOLStat() {
        try{
            playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n";
            playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
        } catch (JSONException e) {
        e.printStackTrace();
        }
    }

    public void setPlayerDEFStat() {
        try{
            playerStat = "\n Position: " + obj.getJSONObject(index).getString("Position") + "\n"
                    + ": Passes Defended: " + obj.getJSONObject(index).getString("PassesDefended") + "\n"
                    + " Interceptions: " + obj.getJSONObject(index).getString("Interceptions") + "\n"
                    + " Sacks: " + obj.getJSONObject(index).getString("Sacks") + "\n"
                    + " Fumbles Forced: " + obj.getJSONObject(index).getString("FumblesForced") + "\n"
                    + " Solo Tackles: " + obj.getJSONObject(index).getString("SoloTackles") + "\n"
                    + " Assisted Tackles: " + obj.getJSONObject(index).getString("AssistedTackles") + "\n";
            playerStat = getStartedString(index, obj, playerStat, " Started this game \n", " Did not start this game \n");
        } catch (JSONException e) {
        e.printStackTrace();
        }
    }

    @NonNull
    private String getStartedString(int index, JSONArray obj, String playerStat, String s, String s2) throws JSONException {
        if (obj.getJSONObject(index).getString("Started").equals("1")) {
            playerStat = playerStat + s;
        } else {
            playerStat = playerStat + s2;
        }
        return playerStat;
    }
}

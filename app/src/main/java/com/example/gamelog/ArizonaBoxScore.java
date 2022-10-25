package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ArizonaBoxScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arizona_box_score);
        try {
            displayScore(getApplicationContext());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public void displayScore(Context context) throws IOException, JSONException {
        String jsonString = null;
        try {
            InputStream is = context.getAssets().open("arizona1.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject(jsonString);
        String homeScore = obj.getString("Score");
        String awayScore = obj.getString("OpponentScore");
        TextView home = (TextView) findViewById(R.id.homeScore);
        home.setText("Home Score: " + homeScore);
    }
}
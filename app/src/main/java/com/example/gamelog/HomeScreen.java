package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    private static String team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    public void nextPage(View view){
        team = view.getTag().toString();
        Intent i = new Intent(HomeScreen.this, Schedule.class);
        startActivity(i);

    }

    public static String getTeam() {
        return team;
    }
}
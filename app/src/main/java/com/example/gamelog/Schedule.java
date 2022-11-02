package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Schedule extends AppCompatActivity {
    private static String week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.schedule);
        TextView team = (TextView) findViewById(R.id.team);
        team.setText(HomeScreen.getTeam());
    }

    public void nextPage(View view){
        week = view.getTag().toString();
        Intent i = new Intent(Schedule.this, BoxScore.class);
        startActivity(i);
    }

    public static String getWeek(){
        return week;
    }
}
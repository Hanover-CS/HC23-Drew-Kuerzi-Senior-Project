package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Activity for displaying the team selected and displaying all available weeks to choose
 */
public class Schedule extends AppCompatActivity {
    private static String week;

    /**
     * @param savedInstanceState
     * Method that is automaticality ran when the activity is created
     * Sets the view to the schedule layout to display buttons
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.schedule);
        TextView team = (TextView) findViewById(R.id.team);
        team.setText(HomeScreen.getTeam());
    }

    /**
     * @param view
     * Sets the week to the button pressed
     * Starts the next activity
     */
    public void nextPage(View view){
        week = view.getTag().toString();
        Intent i = new Intent(Schedule.this, BoxScore.class);
        startActivity(i);
    }

    /**
     * @return The week is returned to be accessible between activities.
     */
    public static String getWeek(){
        return week;
    }
}
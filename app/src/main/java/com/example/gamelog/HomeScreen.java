package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Activity for loading NFL teams on the front page
 */
public class HomeScreen extends AppCompatActivity {
    private static String team;

    /**
     * @param savedInstanceState
     * Method that is automaticality ran when the activity is created
     * Sets the view to the home_screen layout to display buttons
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    /**
     * @param view
     * Sets the team name to the button pressed
     * Starts the next activity
     */
    public void nextPage(View view){
        team = view.getTag().toString();
        Intent i = new Intent(HomeScreen.this, Schedule.class);
        startActivity(i);

    }

    /**
     * @return The team name is returned to be accessible between activities.
     */
    public static String getTeam() {
        return team;
    }
}
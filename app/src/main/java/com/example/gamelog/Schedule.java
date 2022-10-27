package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arizona_schedule);
    }

    public void nextPage(View view){
        switch (view.getId()) {
            case (R.id.week1):
                Intent i = new Intent(Schedule.this, ArizonaBoxScore.class);
                startActivity(i);
                break;
        }
    }
}
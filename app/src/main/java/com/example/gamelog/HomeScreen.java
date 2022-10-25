package com.example.gamelog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    public void nextPage(View view){
        switch (view.getId()) {
            case (R.id.arizona):
                Intent i = new Intent(HomeScreen.this, ArizonaSchedule.class);
                startActivity(i);
                break;
        }
    }
}
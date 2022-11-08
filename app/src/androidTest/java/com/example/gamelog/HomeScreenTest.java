package com.example.gamelog;

import android.content.Context;
import android.widget.Button;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HomeScreenTest{
    @Rule
    public ActivityScenarioRule<HomeScreen> rule = new ActivityScenarioRule<>(HomeScreen.class);

    @Test
    public void getTeamTest() {
        ActivityScenario<HomeScreen> scenario = rule.getScenario();
        // Your test code goes here.
        scenario.onActivity(activity -> activity.findViewById(R.id.arizona).performClick());
        assertEquals("Arizona Cardinals", HomeScreen.getTeam());
    }


}

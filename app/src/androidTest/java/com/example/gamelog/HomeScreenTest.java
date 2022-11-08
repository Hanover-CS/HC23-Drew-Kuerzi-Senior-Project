package com.example.gamelog;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class HomeScreenTest{
    @Rule
    public ActivityScenarioRule<HomeScreen> rule = new ActivityScenarioRule<>(HomeScreen.class);

    @Test
    public void getTeamTest() {
        ActivityScenario<HomeScreen> scenario = rule.getScenario();
        scenario.onActivity(activity -> activity.findViewById(R.id.arizona).performClick());
        assertEquals("Arizona Cardinals", HomeScreen.getTeam());
    }


}

package com.example.gamelog;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ScheduleTest {
    @Rule
    public ActivityScenarioRule<Schedule> rule = new ActivityScenarioRule<>(Schedule.class);

    @Test
    public void getWeekTest() {
        ActivityScenario<Schedule> scenario = rule.getScenario();
        scenario.onActivity(activity -> activity.findViewById(R.id.week1).performClick());
        assertEquals("Week 1", Schedule.getWeek());
    }
}

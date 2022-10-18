package com.example.gamelog;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportsDataIOTest {
    String baseUrl = "https://api.sportsdata.io/v3/nfl/scores/json/GameStatsByWeek";
    String season = "2022REG";
    String week = "1";
//    SportsDataIOReader io = new SportsDataIOReader(baseUrl,season, week, key);

    @Test
    public void fakeTest(){
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void getURLTest(){
//        assertFalse(io.getUrlString() == "");
//    }
//
//    public void getSportsDataTest(){
//        String data = io.getSportsData();
//        assertFalse((data == ""));
//    }
}

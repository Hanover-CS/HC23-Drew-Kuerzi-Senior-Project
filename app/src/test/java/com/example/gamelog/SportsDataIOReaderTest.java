package com.example.gamelog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class SportsDataIOReaderTest {
    String baseUrl = "https://api.sportsdata.io/v3/nfl/stats/json/PlayerGameStatsByTeam/";
    String team = "ARI";
    String week = "1";
    String key = "a3933e1e58d54f1dac244a8dda94b7c4";

    @Test
    public void simpleTest(){
        assertEquals(2,2);
    }

    @Test
    public void getUrlTest(){
        SportsDataIOReader io = new SportsDataIOReader(baseUrl, week, team, key);

        assertEquals("https://api.sportsdata.io/v3/nfl/stats/json/PlayerGameStatsByTeam/2022REG/1/ARI?key=a3933e1e58d54f1dac244a8dda94b7c4",io.getUrlString() );
    }

    @Test
    public void getSportsDataTest(){
        SportsDataIOReader io = new SportsDataIOReader(baseUrl, week, team, key);
        assertEquals("`", io.getSportsData());

    }

}

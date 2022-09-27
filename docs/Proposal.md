## NFL Box Score Recap
### Main Features
Not everyone has access to tv networks that show the football games that someone would want to watch, or maybe they are just too busy while a game is on, so a much easier way would be to get
end-of-game stats all on your mobile device. This android application will allow NFL football enthusiasts to have access to information on any previous NFL game.
Many people enjoy fantasy football or just keeping up to date on what happens in the NFL,
so this app will have all the results from a game available for you right at your fingertips.

The reason for someone to download this app, would be anyone who would like to view the results quickly and easily.
When the application is opened on your android device, there will be a list of all the NFL teams. From that screen you will pick the team you would like to retrieve a box score from. 
After that, the team's entire schedule will be shown for you to pick the specific game and view the final box score.
With the box score you will have access to the score of the game, offensive stats, defensive stats, and any other touchdowns from special teams.
Offensive stats will show individual player's and their yardages/touchdowns, while defensive stats will show player's tackles, interceptions, sacks or any other major plays.
These stats become available only after a game has been finished, so if you are unable to watch the game or would like to recap on a game from weeks before, using this app will provide you with what you need.
In particular fantasy football players will be available to make calculated rosters and trades all by viewing these box scores. 
This app will be very easy to access and traverse to find what you're looking for.



### Similar Applications, and Comparisons
There are applications that already exist on the google play store, such as [Sports Alert: NFL Edition][4], [NFL Mobile][2], [NFL Scores and Schedule 2022][1], and [Espn][3].
All these apps have stats over the NFL teams and players that you can access in some way, as well as other features too.

Sports Alert sends important notifications to your device so you are aware of anything someone may want to know about a given game right once it happens. My application will not have notifications, but the
information on the notifications will be similar to what you can find on the box scores within my app. 
They also have a feature that will be similar, where you can view that stats of individual teams and players.

NFL Mobile is another app that comes at a cost if you  want live footage and additional features to stay up to date on live games.
In addition they have a publication feature that shows news surrounding teams and players.

NFL Schedule and Scores 2022, is used to view all team schedules for the 2022 season and has a feature of live score updates, but they do not show the actual in game stats of the players.
This app is similar because they both have access to team schedules and scores but there app has live updates and they do not have player stats.

Finally, ESPN, does not have NFL live footage like the NFL Mobile app but they do have many of the same features such as live stats and scores, along with news headlines.

## API
In order to get the stats for the games, it can be easier to retrieve them from an outside source. I will be using [Sportsdata.io][5] as my api where I will access all my information for team schedules, scores, and individual player stats. Whenever someone
requests to view a games box score, the app will send a request to Sportsdata.io and receive the updated information in a json or xml file from them to be parsed and displayed on the app.

## Programming Language
There are different languages used to create Android applications. XML is the markup I chose that will be used for the display and layout of the viewable objects in the app while Java will be the programming language to control the behavior of those viewed objects.
Java language is an object oriented programming where functions revolve around the objects created.
For example XML will be used to get a button to appear on the screen and the button would be the object that Java functions will use to make something happen, such as move to the next page when the button is pressed.

## Libraries
Using Android Studio IDE, you are set up with many different android libraries that allow access to the android emulator, debugging, testing, and build tools.
Android Studio gives a default JDK with many different java libraries needed for the application.
Also, in order to communicate with the API, the app will probably need a protocol library for some form of connection, so possibly using an apache httpclient library will be used for this.
This http client will allow the app to request and retrieve the files from the api server.
Lastly, the app will need a json library for parsing of the json file retrieved from the api.

[1]: https://play.google.com/store/apps/details?id=com.tedkeilman.nflSchedule
[2]: https://play.google.com/store/apps/details?id=com.gotv.nflgamecenter.us.lite
[3]: https://play.google.com/store/apps/details?id=com.espn.score_center&gl=US
[4]: https://play.google.com/store/apps/details?id=lunosoftware.nflscores&hl=en
[5]: https://sportsdata.io/developers/api-documentation/nfl
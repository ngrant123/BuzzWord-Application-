# BuzzWord-Application-
Code for the BuzzWord application

BuzzWord Application 

The purpose of this project is to show off a game that I created called BuzzWord. The game is an educational one and is meant to be 
played with one person at a time.

BuzzWord is an educational game that starts off by asking the user to login or create a new profile. If the user presses login and 
types in a username that has never been used before, the program will notify the user that this is an incorrect login. After either 
a new profile is entered or a user logins, the program progresses to a next screen that allows the user to either play the game, learn
what the game is about, or view the user's profile. When the pick game mode button is clicked, it brings the user to a screen that 
shows the different catergories available in this game. The three catergories are Famous People, Countries, and Dogs. Right now there 
are only three levels available and when the user clicks on a level the game begins.

The point of this game is to provid an educational experience to the user. When the user starts playing, a screen is displayed with 
a grid of circles. The size of this grid depends on what level the user is on. Located in each of these circles is a random letter. The
point of this game is for the user to make words by "connecting" each of the circles together. When you click on the circle the letter is 
displayed to the right. If the word that the user picks is contained in the list, the user is awarded a certain number of points 
depending on the length of the word. When all of the words are picked from the list, the user is notified and the level is completed. 
When the user goes back to the level screen, the next level is made accessible. 

Additionally, while the user is attempting to connect all of the words together a timer is counting down on the right side of the screen.
For example level 1 is timed for 10 seconds, level 2 for 15 seconds, and level 3 for 30 seconds. On the bottom is a pause button, that 
when pressed, disables the entire grid and stops the timer for about 10 seconds. This allows the user to gather his/her thoughts and attempt
to figure out the words. If the user exits the level when the timer is ticking down, the timer is stopped and restarted when the user
enters the level again. 

The whole application is coded in Java and uses JavaFX and JSONFactory.

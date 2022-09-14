Section 0: Folder Contents
Section 1: How to Run the Program
Section 2: Goal of the Game
Section 3: How to Play
Section 4: Custom Features
Section 5: Art Work



******************************************************************

		SECTION 0: FOLDER CONTENTS

******************************************************************

2D Space Arcade Game (folder):
	readme.txt
	Collectable.java
	Controller.java
	DodgerGame.java
	Enemy.java
	Inventory.java
	Player.java
	Scene.java
	StdDraw.java
	Weapon.java
	assets (folder):
		26 items total

******************************************************************

		SECTION 1: HOW TO RUN PROGRAM

******************************************************************

Note:When instructed to type something in don't include quotation marks.

FOR MAC USERS:
	1. Locate Pathname for program -- Right-click on the DodgerGame.java file. Select Get Info. The Pathname is under General > Where. Right-click on the location of the program. Select Copy as Pathname.
	For example, my Pathname is "/Users/cntrlspace/Downloads/2D Space Arcade Game".
	**If you do not see Where under the General tab you will need to expand the General tab by clicking on the arrow that is located next to General.**

	2. Open Terminal -- Click on the magnifying glass on the top right corner of the screen. Type "Terminal" into the search bar. Click on the Terminal application to open it.

	3.Move to the DodgerGame.java directory in Terminal -- In the Terminal, type "cd" followed by a space. Right-click on the area after the space and select Paste. Press Enter.
	Example: "cd /Users/cntrlspace/Downloads/2D Space Arcade Game"

	4. Compile the DodgerGame.java file -- In the Terminal, type in "javac DodgerGame.java". Press Enter.

	5. Run the program -- In the Terminal, type in "java DodgerGame". Press Enter. The game will start.

	6. To play again, Repeat Step 5.


WINDOWS:
	1.Locate path for program -- Right-click on the DodgerGame.java file. Click Properties. The path is under General > Location. Find the Path next to "Location". To copy the path, double-click it to highlight it with the mouse, and then right-click and select Copy. To paste the path once it has been copied, right-click and select Paste.

	2.Open Git Bash -- Open the Start menu by clicking on the Windows icon on the bottom left of the screen. Type in "Git Bash Desktop App" into the search bar. Click on the icon to open it.

	3.Move to the DodgerGame.java directory in Git Bash -- In Git Bash, type "cd" followed by a space. Right-click on the area after the space and select Paste. Press Enter.
	Example "cd \Users\nacho\Downloads\2D Space Arcade Game"

	4.Compile the DodgerGame.java file -- In Git Bash, type in "javac DodgerGame.java". Press Enter.

	5.Run the program -- In Git Bash, type in "java DodgerGame". Press Enter. The game will start.

	6. To play again, Repeat Step 5.


******************************************************************

		SECTION 2: GOAL OF THE GAME

******************************************************************


Navigate through space by dodging or shooting the asteroids. Survive each level for 40 seconds and you will advance to the next level. The final level contains a boss that you need to destroy in order to win the game. The boss will also shoot lasers back at you and they cause more damage than your own lasers. The final level has no time limit and will only conclude when both players have no health or the boss has been defeated. Asteroids will continue to fall and do not affect the boss.


******************************************************************

		SECTION 3: HOW TO PLAY

******************************************************************

## Player 1 : Character will load on the right side

Use the mouse to control movement. You may click in a general direction to move your player or simply hold down the left mouse button to navigate your player.


## Player 2 : Character will load on the left side

Use the standard W,A,S,D keys to control the player movement.

	w - move up
	a - move left
	s - move down
	d - move right

******************************************************************

		SECTION 4: CUSTOM FEATURES

******************************************************************

1. Multiple Levels
	-This game contains 3 total levels. When the timer reaches 40 a countdown for the start of the next level will begin and then the player will advance to the next level. 


2. Boss level
	-The 3rd level is the final level and contains a boss that will shoot lasers at the player as well as a continuous bombardment of asteroids that the player will need to shoot or dodge.

3. Different types of enemies
	-This game contains a total of 4 enemies that can hurt the player. The boss enemy is equipped with a laser that will damage the player. Running into the boss will also damage the player. There are 3 different types of asteroids in the game with varying sizes. The bigger size asteroids will deal more damage to the player and it will also take more laser hits to destroy them. 

4. Player can shoot at the asteroids
	-The player is equipped with lasers that automatically shoot continuously.

5. Health Powerups
	-The player can gained more health by collecting the blue pills and it will add 5 extra HP to the player. There is no limit on the amount the player can hold.

6. Two Player support
	-The game can be played with 2 players. Player 1 is controlled with the mouse and Player 2 is controlled with the keyboard. Both players have a starting HP of 50 and the game can continue if there is at least 1 player surviving.

7. Star collection for points
	-There are 3 types of stars that the player can collect, gold, silver, and bronze. Collecting stars will gain the player points. The different color stars have different point values. The gold star is worth the most and also is harder to collect because it is the fastest star to travel across the field.

8. Background Animation Scroll
	-The background scrolls to give a better experience for movement in space.

9. Status Bar and Inventory
	-The HUD at the top contains each player's health status and score. Each player can compete against each other through the collection of stars. The inventory is displayed at the bottom and it shows the total amount of each stars that both players have collected throughout the game. The bottom also shows the timer. When the boss level is reached the boss's health status will be displayed in red at the top of the screen.

******************************************************************

		SECTION 5: ART WORK

******************************************************************
https://opengameart.org/content/pointy-numbers

https://opengameart.org/content/level-up-speed-up-etc-animations

Space Shooter (Redux, plus fonts and sounds) by Kenney Vleugels (www.kenney.nl)

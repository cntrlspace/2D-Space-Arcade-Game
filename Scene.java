//  Nicole Lonatro
// Homework 5 - Objects

import java.util.ArrayList;

public class Scene {
	//  Scene Attributes - Instance Variables
	private int width;
	private int height;
	private int y;
	private int start;
	private int end;
	private int rate;
	private double speed;
	private ArrayList<Enemy> monsters;
	private ArrayList<String> image;
	private ArrayList<Collectable> stars;
	private ArrayList<Weapon> greenLasers;
	private ArrayList<Weapon> redLasers;
	private ArrayList<Weapon> greenLasers2;
	private ArrayList<Collectable> powerups;
	private Player player;
	private Player player2;
	private Enemy boss;
	private long laserTime;
	private long bossTime;
	private long powerTime;
	private boolean bosslevel;

	//  Scene Constructor
	public Scene(int scrollStart, int scrollEnd, double scrollSpeed) {
		this.start = scrollStart;						//  creates background scroll movement
		this.end = scrollEnd;
		this.speed = scrollSpeed;
		this.width = 600;								//  set scene width
		this.height = 350;								//  set scene height
		this.y = scrollStart;

		monsters = new ArrayList<Enemy>();				//  create arrays for new Objects
		stars = new ArrayList<Collectable>();
		greenLasers = new ArrayList<Weapon>();
		greenLasers2 = new ArrayList<Weapon>();
		redLasers = new ArrayList<Weapon>();
		powerups = new ArrayList<Collectable>();


		//  Set Game Window GUI Size
		StdDraw.setCanvasSize(width, height);			//  set canvas size for image
		StdDraw.setXscale(0.0, width);					//  set x=0 at right
		StdDraw.setYscale(height, 0.0);					//  set y=0 at top
		laserTime = System.currentTimeMillis();
		bossTime = System.currentTimeMillis();
		powerTime = System.currentTimeMillis();
	}

	//  Draw Method - Adds background image for scene, using center point
	public void draw() {
		StdDraw.picture(width/2, y, image.get(0));				//  draw scene background

			for (Enemy monster : monsters) {					//  for each element in monsters, assign the
				monster.draw();									//  element to the 'monster' reference variable
			}
			for (Collectable star : stars) {
				star.draw();
			}
			for (Weapon greenLaser : greenLasers) {
				greenLaser.draw();
			}
			for (Weapon greenLaser2 : greenLasers2) {
				greenLaser2.draw();
			}
			for (Collectable powerup : powerups) {
				powerup.draw();
			}
		player.draw();
		player2.draw();

		if (boss.getHealth() <= 0 && bosslevel == true) {					//  draws winning scene
			StdDraw.picture(width/2, height/2, image.get(16), 400, 200);
		}
		if (player.getHealth() <= 0 && player2.getHealth() <= 0) {			//  draws game over scene
			StdDraw.picture(width/2, height/2, image.get(8), 350, 350);
		}
		StdDraw.picture(112, 50, image.get(17), 150, 80);					//  draw player HUD left
		StdDraw.picture(486, 50, image.get(17), 150, 80);					//  draw play HUD right
		StdDraw.text(486, 40, "Player 1 HP: " + player.getHealth());		//  show player's level and score
		StdDraw.text(486, 63, "Score: " + player.getScore());
		StdDraw.text(112, 40, "Player 2 HP: " + player2.getHealth());	
		StdDraw.text(112, 63, "Score: " + player2.getScore());
	
	}

	//  Draw Method - Boss Scene
	public void draw(String image) {				//  draws boss and boss lasers
		for (Weapon redLaser : redLasers) {			//  show boss HUD
			redLaser.draw();
		}
		boss.draw();
		StdDraw.picture(299, 50, image, 150, 80);	//  boss HUD - top, middle
		StdDraw.text(299, 51, "Boss HP: " + boss.getHealth());
	}

	// Add Monsters - continuously gets invoked in DodgerGame while loop when game starts
	public void addMonster() {
		double x = (Math.random() * (width - 64));			//  assign random x value
		double y = -32;										//  set y so starts outside screen(top)
		int width = 35;
		int height = 35;
		double speed = (int) (1 + Math.random() * 5);		//  varies speed for each enemy
		int damage = 20;

		//  Arguments for new Enemy(x, y, image, width, height, speed, damage caused)
		Enemy large = new Enemy(x + 32, y, image.get(1), 
										width+5, height+5, speed, damage);			//  create new Enemy object
		Enemy medium = new Enemy(x - 32, y, image.get(2), 
										width* 3/4, height* 3/4, 5, damage/2);
		Enemy small = new Enemy(x + 10, y, image.get(3), 
										width/2, width/2, 7, damage/4);
		monsters.add(large);		//  add enemy objects to monsters array
		monsters.add(medium);
		monsters.add(small);
	}

	//  Add Stars - (x, y, image, speed, points)
	public void addStar() {
		double x = (width - 150) * Math.random() + 70;
		double y = -32;
		int points = 5;

		Collectable gold = new Collectable(30 + x - (Math.random() * 60), y, image.get(5), 9.0, points);
		Collectable silver = new Collectable(x * Math.random() + (Math.random() * 150), y, image.get(6), 5.0, points - 2);
		Collectable bronze = new Collectable(x * Math.random(), y, image.get(7), 2.5, points - 4);
		
		stars.add(gold);			//  add new objects to stars array
		stars.add(silver);
		stars.add(bronze);
	}

	//  Add Powerups - (x, y, image)
	public void addPowerups() {
		long now = System.currentTimeMillis();
		double x = (width - 100) * Math.random() + 100;
		double y = -32;

		Collectable canon = new Collectable(x - (Math.random() * 50) , y, image.get(21));			//  adds 5 health to player
		if (now - powerTime > 300) {
			powerups.add(canon);
			powerTime = now;
		}
	}

	//  Add Weapon - Lasers Control rate that lasers shoot on screen
	public void addLasers(Weapon forPlayer1, Weapon forPlayer2, Weapon forBoss) {
		long now = System.currentTimeMillis();
		if (now - laserTime > 300){						//  Player lasers shoot every .3 seconds
			greenLasers.add(forPlayer1);
			greenLasers2.add(forPlayer2);
			laserTime = now;
			rate++;
		}
		if (rate == 2) {								//  Boss lasers shoot at slower pace
			redLasers.add(forBoss);						//  Boss lasers cause more damage than Player's
			rate = 0;
		}	
	}

	//  Movement for Objects on Screen
	public void update() {
		for (Enemy monster : monsters) {
			monster.move();
		}
		for (Collectable star : stars) {
			star.move();
		}
		for (Weapon greenLaser : greenLasers) {
			greenLaser.moveUp();
		}
		for (Weapon greenLaser2 : greenLasers2) {
			greenLaser2.moveUp();
		}
		for (Collectable powerup : powerups) {
			powerup.move();
		}
		for (Weapon redLaser : redLasers) {
			redLaser.moveDown();
		}
		this.y += this.speed;							//  creates background scroll movement
		if (this.y == this.end) this.y = this.start;	//  add to background y and then reset
	}

	//  Add Boss - Scene for Boss Level
	public void addBoss() {
		bosslevel = true;
		long now = System.currentTimeMillis();
		if (boss.getY() <= 100) {						//  move boss based on time
			boss.move();								//  movement based on boundaries would not work
		}
		if (now - bossTime > 0) {
			if (now - bossTime > 1 && now - bossTime < 3000) {
				boss.moveRight();
			} else if (now - bossTime > 3050 && now - bossTime < 9000) {
				boss.moveLeft();
			} else {
				boss.moveRight();
			}
			if (now - bossTime > 12000) {
				bossTime = now;
			}
		}
	}

	//  Reset Player's position at start of new level
	public void levelUp() {
		if (player.getHealth() > 0) this.player.setCoordinates(525.0, 300);
		if (player2.getHealth() > 0) this.player2.setCoordinates(75.0, 300);
	}

	//  Getters & Setters
	public Player getPlayer() {
		return this.player;
	}

	public Player getPlayer2() {
		return this.player2;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setPlayer2(Player player) {
		this.player2 = player;
	}

	public ArrayList<Enemy> getMonsters() {
		return this.monsters;
	}

	public ArrayList<Collectable> getStars() {
		return this.stars;
	}

	public ArrayList<Weapon> getGreenLasers() {
		return this.greenLasers;
	}

	public ArrayList<Weapon> getGreenLasers2() {
		return this.greenLasers2;
	}

	public ArrayList<Weapon> getRedLasers() {
		return this.redLasers;
	}

	public ArrayList<Collectable> getPowerups() {
		return this.powerups;
	}

	public void setEnemy(Enemy enemy) {
		this.boss = enemy;
	}

	public Enemy getEnemy() {
		return this.boss;
	}

	//  All images in an array
	public String getImage(int index) {
		return image.get(index);
	}

	public void setImage() {
		image = new ArrayList<String>();
		
		image.add("assets/space-background.png");		//  0 - scene
		image.add("assets/big1.png");					//  1 - enemy big meteor
		image.add("assets/medium.png");					//  2 - enemy medium meteor
		image.add("assets/small.png");					//  3 - enemy small meteor
		image.add("assets/player1-blue.png");			//  4 - player 1 -> mouse
		image.add("assets/star_gold.png");				//  5 - gold star
		image.add("assets/star_silver.png");			//  6 - silver star
		image.add("assets/star_bronze.png");			//  7 - bronze star
		image.add("assets/GameOver-14.gif");			//  8 - game over prompt
		image.add("assets/laserG.png");					//  9 - player weapon laser 
		image.add("assets/numbers-5.png");				//  10 - number 5
		image.add("assets/numbers-4.png");				//  11 - number 4
		image.add("assets/numbers-3.png");				//  12 - number 3
		image.add("assets/numbers-2.png");				//  13 - number 2
		image.add("assets/numbers-1.png");				//  14 - number 1
		image.add("assets/numbers-0.png");				//  15 - number 0
		image.add("assets/YouWin.gif");					//  16 - win prompt
		image.add("assets/panel-5.png");				//  17 - left HUD
		image.add("assets/boss.png");					//  18 - boss
		image.add("assets/panel-4red.png");				//  19 - boss HUD
		image.add("assets/panel-1.png");				//  20 - bottom panel	
		image.add("assets/pill_blue.png");				//  21 - weapon power up
		image.add("assets/LevelUp-15.gif");				//  22 - level up prompt
		image.add("assets/laserR.png");					//  23 - enemy laser
		image.add("assets/player1-green.png");			//  24 - player 2 -> keyboard
	}
}
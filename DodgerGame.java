//  Nicole Lonatro
// Homework 5 - Objects
//

public class DodgerGame {
	//  Dodger Game Attributes - Instance Variables
	private Scene scene;
	private Controller controller;
	private Controller controller2;
	private boolean isOver;
	private boolean levelUp;
	private boolean bossLevel;
	private int timer;
	private int starRate;
	private int levelUpGraphicTimer;
	private static int levelCounter;
	private long startTime;								//  add time to control rate of stars generating in game
	private long screenTimer;
	private Inventory bag;


	//  Main Class Method - Main Game Loop
	public static void main(String[] args) {
		DodgerGame game = new DodgerGame();				//  making a new DodgerGame object with a reference varible called 'game'
														//  
		while (game.isOver  == false) {					//  start of game loop
			game.update();
			game.render();
		}
		while (game.isOver == true) {					//  continues to render gif ending prompts
			game.render();
		}
	}

	//  Create A New DodgerGame - Constructor - Gets invoked first in main method
	public DodgerGame() {
		isOver = false;
		startTime = System.currentTimeMillis();
		screenTimer = System.currentTimeMillis();

		// Scene object arguments(start, end, scroll speed)
		scene = new Scene(-670, 1000, 2);								//  game object creates a new Scene object
		scene.setImage();
		Player player = new Player(450.0, 187.5, scene.getImage(4));	//  new Player object gets created w/ reference variable 'player'
		Player player2 = new Player(150.0, 175, scene.getImage(24));
		this.scene.setPlayer(player);
		this.scene.setPlayer2(player2);
		controller = new Controller(player);
		controller2 = new Controller(player2);							//  new Controller object gets created w/ reference variable 'controller'
		Enemy boss = new Enemy(300, -35, scene.getImage(18));
		bag = new Inventory(scene);

		this.scene.setEnemy(boss);
		this.timer = 0;
		this.levelUpGraphicTimer = 0;
		this.levelCounter = 1;
	}

	//  Updates Game Code
	public void update() {

		controller.update();
		controller2.keyUpdate();
		Player player = scene.getPlayer();
		Player player2 = scene.getPlayer2();
		long now = System.currentTimeMillis();
		if (now - this.screenTimer > 1000) {				//  Adjusts time shown on GUI to increment for every second
			if (levelUp == true) {							//  used for switch statement countdown
				levelUpGraphicTimer++;
			} else if (levelUp == false) {
				levelUpGraphicTimer = 0;
			}
			this.timer++;
			this.screenTimer = now;
		}
		if (now - this.startTime > 800) {					//  starts loop to generate stars every .8 sec
			scene.addMonster();
			this.starRate++;
			this.startTime = now;							//  resets time to start count again
		}
		if (starRate == 6 || starRate == 0) {
			scene.addPowerups();
			scene.addStar();
			this.starRate = -4;
		}
		Enemy boss = scene.getEnemy();
		Weapon playerLaser = new Weapon(6, 15, 3, scene.getImage(9), scene, player);		//  (width, height, damage, image, Player)
		Weapon playerLaser2 = new Weapon(6, 15, 3, scene.getImage(9), scene, player2);		//  (width, height, damage, image, Player)
		Weapon bossLaser = new Weapon(scene.getImage(23), scene);
		scene.addLasers(playerLaser, playerLaser2, bossLaser);
		for (Enemy monster : scene.getMonsters()) {							//  checks game over condition for every enemy on screen
			if (player.isTouching(monster)) {								//  if player & enemy collide...
				player.isHit(monster);										//  ...player hp goes down, enemy strength = 0;
				monster.reset();							
			}
			else if (player.isTouching(boss)) player.isHit(boss);

			if (player2.isTouching(monster)) {
				player2.isHit(monster);
				monster.reset();
			} 
			else if (player2.isTouching(boss)) player2.isHit(boss);
			for (Weapon greenLaser2 : scene.getGreenLasers2()) {
				if (greenLaser2.isTouching(monster)) monster.isHit(greenLaser2);
				else if (greenLaser2.isTouching(boss)) boss.isHit(greenLaser2);
			}	
			for (Weapon greenLaser : scene.getGreenLasers()) {
				if (greenLaser.isTouching(monster)) monster.isHit(greenLaser);
				else if (greenLaser.isTouching(boss)) boss.isHit(greenLaser);
			}
			if (levelUp == true) monster.reset();
		}
		for (Collectable powerup : scene.getPowerups()) {
			if (player2.hasGained(powerup)) {
				player2.addHealth(powerup);
				powerup.reset();
				bag.showPowerup(powerup);
				break;
			}
		}	
		for (Collectable powerup : scene.getPowerups()) {
			if (player.hasGained(powerup)) { 
				player.addHealth(powerup);
				powerup.reset();
				bag.showPowerup(powerup);
				break;
			}
		}	
		for (Weapon redLaser : scene.getRedLasers()) {
			if (redLaser.isTouching(player)) {
				player.isHit(redLaser);
				redLaser.reset();
				break;
			}
			if (redLaser.isTouching(player2)) {
				player2.isHit(redLaser);
				redLaser.reset();
				break;
			}
		}
		for (Collectable star : scene.getStars()) {
			if (player.hasGained(star)) {
				player.addScore(star);
				bag.showStar(star);
				star.reset();
				break;
			}
			if (player2.hasGained(star)) {
				player2.addScore(star);
				bag.showStar(star);
				star.reset();
				break;
			}
			if (levelUp == true) {
				star.reset();
			}
		}
		if (boss.getHealth() <= 0 || (player.getHealth() <= 0 && player2.getHealth() <= 0)) {		//  game over conditions
			isOver = true;
		}
		if (player.getHealth() <=0) player.setCoordinates(-1000,1000);				//  if either player hp reaches 0 ...
		else if (player2.getHealth() <= 0) player2.setCoordinates(-1000, 1000);		//  ... send player off screen

		if (levelCounter == 3) {									//  boss level conditions
			bossLevel = true;
			if (levelUp == false) {
				scene.addBoss();
			}
		} 

		if (this.timer >= 40 && levelCounter < 3) {					//  next level conditions
			levelCounter++;
			this.timer = 0;
			levelUp = true;
		}
		scene.update();
	}

	//  Draws Game Code
	public void render() {
		scene.draw();												//  draw main scene, player, enemy, collectables, weapon
		bag.draw();													//  draw so objects float behind inventory and bag items on top
		Enemy boss = scene.getEnemy();
		if (bossLevel == true) {									//  triggers drawing for final boss scene
			scene.draw(scene.getImage(19));							//  show boss middlle panel
		}
	
		StdDraw.setPenColor(StdDraw.WHITE);							//  change text to white	
		StdDraw.text(440, 338, "Time: " + this.timer);				//  show time indicator
		if (levelUp == true) { 										//  prompt 'level up' graphics
			StdDraw.picture(300, 130, scene.getImage(22), 85, 85);
		}	
		switch (levelUpGraphicTimer) {								//  show count down to start of next level
			case 1:
				StdDraw.picture(300, 230, scene.getImage(10));		//  5
				break;
			case 2:
				StdDraw.picture(300, 230, scene.getImage(11));		//  4
				break;	
			case 3:
				StdDraw.picture(300, 230, scene.getImage(12));		//  3
				break;
			case 4:
				StdDraw.picture(300, 230, scene.getImage(13));		//  2
				break;
			case 5:
				StdDraw.picture(300, 230, scene.getImage(14));		//  1
				scene.levelUp();
				break;
			case 6:
				StdDraw.picture(300, 230, scene.getImage(15));		//  0
				this.timer = 0;
				levelUp = false;
				boss.setHealth(100);
				break;
		}
		StdDraw.show(100);
	}
}

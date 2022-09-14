//  Nicole Lonatro
// Homework 5 - Objects

public class Controller {
	//  Controller Attributes - Instance Variables
	private Player player;
	private Weapon laser;

	//  Controller - Constructor
	public Controller(Player player) {
		this.player = player;
	}

	//  Mouse Movement
	public void onMousePress() {
		if (StdDraw.mousePressed()) {
			double mouseX = StdDraw.mouseX();
			double mouseY = StdDraw.mouseY();
			double playerX = player.getX();
			double playerY = player.getY();

			if (mouseY < playerY) playerY -= player.getSpeed();
			if (mouseY > playerY) playerY += player.getSpeed();
			if (mouseX < playerX) playerX -= player.getSpeed();
			if (mouseX > playerX) playerX += player.getSpeed();
			
			player.move(playerX, playerY);
		}
	}

	public void update() {
		onMousePress();
	}

	//  Keyboard movement
	public void keyUpdate() {
		double playerX = player.getX();
		double playerY = player.getY();

		if (StdDraw.isKeyPressed(87)) playerY -= player.getSpeed();
		if (StdDraw.isKeyPressed(83)) playerY += player.getSpeed();
		if (StdDraw.isKeyPressed(65)) playerX -= player.getSpeed();
		if (StdDraw.isKeyPressed(68)) playerX += player.getSpeed();
		
		player.move(playerX, playerY);
	}
}
//  Nicole Lonatro
// Homework 5 - Objects

public class Player {
	//  Player Attributes - Instance Variables
	private String image;
	private int width;
	private int height;
	private double x;
	private double y;
	private int speed;
	private int health;
	private int score;

	//  Player - Constructor
	public Player(double x, double y, String image) {
		this.x = x;									//  set x position
		this.y = y;									//  set y position
		this.width = 32;							//  set width
		this.height = 32;							//  set height
		this.image = image;							//  set image filename
		this.speed = 10;							//  set speed
		this.health = 50;
	}

	//  Add Player Image
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	public void move(double x, double y) {
		this.y = y;
		this.x = x;
	}

	//  Getters and Setters
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getSpeed() {
		return this.speed;
	}

	public int getHealth() {
		return this.health;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setCoordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void addHealth(Collectable gameObject) {
		this.health += gameObject.getHealth();
	}

	//  Collision Detection - Adjust hitzone based on the width and height of the enemies, allows different size enemy
	public boolean isTouchingX(Enemy gameObject) {
		int hitzone = (gameObject.getWidth() - 2);
		return this.x <= gameObject.getX() + hitzone && gameObject.getX() <= this.x + hitzone;
	}

	public boolean isTouchingY(Enemy gameObject) {
		int hitzone = (gameObject.getHeight() - 7);
		return this.y <= gameObject.getY() + hitzone && gameObject.getY() <= this.y + hitzone;
	}

	public boolean isTouching(Enemy gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}

	public void isHit(Enemy gameObject) {
		this.health -= gameObject.getDamage();
	}

	public void isHit(Weapon gameObject) {
		this.health -= gameObject.getDamage();
	}

	public boolean hasGainedX(Collectable starObject) {
		int hitzone = 25;
		return this.x <= starObject.getX() + hitzone && starObject.getX() <= this.x + hitzone;
	}

	public boolean hasGainedY(Collectable starObject) {
		int hitzone = 25;
		return this.y <= starObject.getY() + hitzone && starObject.getY() <= this.y + hitzone;
	}

	public boolean hasGained(Collectable starObject) {
		return this.hasGainedX(starObject) && this.hasGainedY(starObject);
	}

	public void addScore(Collectable starObject) {
		this.score += starObject.getPoints();
	}












}
//  Nicole Lonatro
//  Homework 5 - Objects

public class Collectable {
	//  Attributes - Instance Variables
	private double x;
	private double y;
	private double speed;
	private int width;
	private int height;
	private int points;
	private String image;
	private int health;

	//  Collectable - Constructor - Stars
	public Collectable(double x, double y, String image, double speed, int points) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.speed = speed;
		this.points = points;
		this.width = 25;
		this.height = 25;
	}

	//  Collectable - Powerups
	public Collectable(double x, double y, String image) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.speed = 5;
		this.width = 25;
		this.height = 25;
		this.health = 5;
	}

	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//  Add speed to y to show movement across screen
	public void move() {
		this.y += this.speed;
	}

	//  Getters and Setters
	public void reset() {
		this.points = 0;
		this.x = -50;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String getImage() {
		return this.image;
	}

	public int getPoints() {
		return this.points;
	}

	public int getHealth() {
		return this.health;
	}
}
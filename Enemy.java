//  Nicole Lonatro
// Homework 5 - Objects

import java.util.ArrayList;

public class Enemy {
	//  Enemy Attributes - Instance Variables
	private String image;
	private int width;
	private int height;
	private double x;
	private double y;
	private double speed;
	private int damage;
	private int health;
	private Scene scene;
	//private ArrayList<Enemy> enemy;

	//  Enemy - Constructor
	public Enemy(double x, double y, String image, int width, int height, double speed, int damage) {
		this.x = x;										//  set x position
		this.y = y;										//  set y position
		this.width = width; 							//  set width
		this.height = height;							//  set height
		this.image = image;
		this.speed = speed;								//  generate random number
		this.damage = damage;
		this.health = damage;
	}

	public Enemy(double x, double y, String image) {
		this.x = x;
		this.y = y;
		this.width = 35;
		this.height = 35;
		this.image = image;
		this.speed = 10;
		this.damage = 5;
		this.health = 100;
	}

	//  Adds Enemy Image to Game
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//  Creates object movement illusion
	public void move() {								//  continuously adds a value
		this.y += this.speed;							//  to y, to make star appear
	}													//  to move down screen

	public void moveRight() {
		this.x += this.speed;
	}

	public void moveLeft() {
		this.x -= this.speed;
	}

	public void isHit(Weapon gameObject) {
		this.health -= gameObject.getDamage();
		if (this.health <= 0) { reset(); }
		gameObject.reset();
	}

	//  Getters and Setters
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void reset() {
		this.damage = 0;
		this.x = -50;
	}
}
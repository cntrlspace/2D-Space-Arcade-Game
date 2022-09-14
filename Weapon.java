//  Nicole Lonatro
//  Homework 5 - Objects

public class Weapon {
	private double x;			//  get from player/enemy
	private double y;			//  coordinates based on player/enemy
	private String image;
	private int width;
	private int height;
	private int speed;
	private int damage;
	private Scene scene;
	private Player player;
	private Enemy boss;

	public Weapon(int width, int height, int damage, String image, Scene scene, Player player) {
		this.scene = scene;
		this.player = player;
		this.x = player.getX();
		this.y = player.getY();
		this.width = width;
		this.height = height;
		this.image = image;
		this.damage = damage;
		this.speed = 12;
	}

	public Weapon(String image, Scene scene) {
		this.scene = scene;
		this.boss = scene.getEnemy();
		this.x = boss.getX();
		this.y = boss.getY()+17;
		this.width = 10;
		this.height = 15;
		this.image = image;
		this.damage = 6;
		this.speed = 10;
	}

	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	public void moveUp() {
		this.x = this.x;
		this.y -= this.speed;
	}

	public void moveDown() {
		this.x = this.x;
		this.y += this.speed;
	}

	//  Getter and Setters
	public int getDamage() {
		return this.damage;
	}

	public void reset() {
		this.damage = 0;
		this.x = -50;
	}

	//  Damage Collision for Enemy
	public boolean isTouchingX(Enemy gameObject) {
		int hitzone = (gameObject.getWidth() - 8);
		return this.x <= gameObject.getX() + hitzone && gameObject.getX() <= this.x + hitzone;
	}

	public boolean isTouchingY(Enemy gameObject) {
		int hitzone = (gameObject.getHeight() - 8);
		return this.y <= gameObject.getY() + hitzone && gameObject.getY() <= this.y + hitzone;
	}

	public boolean isTouching(Enemy gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}

	//  Damage Collision for Player
	public boolean isTouchingX(Player gameObject) {
		int hitzone = 20;
		return this.x <= gameObject.getX() + hitzone && gameObject.getX() <= this.x + hitzone;
	}

	public boolean isTouchingY(Player gameObject) {
		int hitzone = 18;
		return this.y <= gameObject.getY() + hitzone && gameObject.getY() <= this.y + hitzone;
	}

	public boolean isTouching(Player gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}
}
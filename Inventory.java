//  Nicole Lonatro
//  Homework 5 - Objects

public class Inventory{
	private Scene scene;
	private boolean addP1Canon;
	private boolean addP2Canon;
	private boolean addStar;
	private int starPoints;
	private int x;
	private int y;
	private double width;
	private double height;
	private boolean bronze;
	private boolean silver;
	private boolean gold;
	private int bronzeCount;
	private int silverCount;
	private int goldCount;

	public Inventory(Scene scene) {
		this.scene = scene;
		this.x = 153;
		this.y = 335;
		this.width = 25;
		this.height = 25;
		this.addP1Canon = false;
		this.addStar = false;
		this.bronze = false;
		this.silver = false;
		this.gold = false;
	}

	public void draw() {
		StdDraw.picture(300, 405, scene.getImage(20), 450, 200);				//  draw bottom HUD
		if (addP1Canon == true) {												//  draw powerup right
			StdDraw.picture(437, 63, scene.getImage(21), width, height);
		}
		if (bronze == true) {													//  draw bronze star
			StdDraw.picture(x, y, scene.getImage(7), width, height);
			StdDraw.text(x + 24, y + 3, " x " + bronzeCount);
		}
		if (silver == true) {													//  draw silver star
			StdDraw.picture(x + 90, y, scene.getImage(6), width, height);
			StdDraw.text(x + 114, y + 3, " x " + silverCount);
		}
		if (gold == true) {														//  draw gold star
			StdDraw.picture(x + 180, y, scene.getImage(5), width, height);
			StdDraw.text(x + 204, y + 3, " x " + goldCount);
		}
		if (addP2Canon == true) {												//  draw powerup left
			StdDraw.picture(90 + 63, y, scene.getImage(21), width, height);
		}
	}

	public boolean showPowerup(Collectable gameObject) {
		this.addP1Canon = true;
		return addP1Canon;
	}

	public boolean showStar(Collectable gameObject) {
		starPoints = gameObject.getPoints();
		switch (starPoints) {			//  determines which star object player, collected
			case 1:						//  adds count to each appropriate star color
				bronze = true;
				bronzeCount++;
				break;
			case 3:
				silver = true;
				silverCount++;
				break;
			case 5:
				gold = true;
				goldCount++;
				break;
		}
		return addStar = true;
	}
}
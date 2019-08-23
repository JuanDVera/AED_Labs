package model;

public class Ship {
	
	private String rank;
	private int health;
	private boolean dead;
	public Ship(String rank, boolean dead) {
		super();
		this.rank = rank;
		this.health = 100;
		this.dead = dead;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
	

}

package model;

public class Ship {
	
	
	private int health;
	private boolean dead;
	public Ship( boolean dead) {
		super();
		
		this.health = 100;
		this.dead = dead;
	}
	public Ship() {
		super();
		
		this.health = 100;
		this.dead = true;
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
	
	
	public boolean isPrime(int number) {
		int c = 2;
		boolean prime=true;
		 
		while ((prime) && (c!=number)){
		  if (number % c == 0)
		    prime = false;
		  c++;
		
		
		
	}
		return prime;
	
	}
	
	

}

package model;

public class Ship {
	
	 
	private int prime;
	private boolean dead;
	public Ship( boolean dead, int prime) {
		super();
		
		this.prime = prime;
		this.dead = dead;
	}
	public Ship(int prime) {
		super();
		this.prime=prime;
	this.dead = false;
	}
	
	public int getPrime() {
		return prime;
	}
	public void setPrime(int prime) {
		this.prime = prime;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
	public boolean isPrime() {
		int c = 2;
		boolean prime=true;
		 
		while ((prime) && (c!=getPrime())){
		  if (getPrime() % c == 0)
		    prime = false;
		  c++;
		
		
		
	}
		if(prime==true) {
			setDead(prime);
		}
		
		return prime;
	
	}
	
	

}

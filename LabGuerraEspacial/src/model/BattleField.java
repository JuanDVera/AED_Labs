package model;

public class BattleField {
	
	
	private Ship[][] ships;
	private int m;
	private int n;
	
	public BattleField(int m, int n) {
		ships= new Ship[m][n];
		this.m=m;
		this.n=n;
	}
	
	
	

}

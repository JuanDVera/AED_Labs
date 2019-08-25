package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Ship;

class JShip {
	
	private Ship ship;

	
	void Escenario1() {
		ship= new Ship();
	}
	
	@Test
	void test1() {
		Escenario1();
		
		
		int a= 2;
		int b= 3;
		int c= 4;
		int d= 5;
		int e= 6;
		int f= 7;
		int g= 8;
		assertTrue(ship.isPrime(a)==true);
		assertTrue(ship.isPrime(b)==true);
		assertTrue(ship.isPrime(c)==false);
		assertTrue(ship.isPrime(d)==true);
		assertTrue(ship.isPrime(e)==false);
		assertTrue(ship.isPrime(f)==true);
		assertTrue(ship.isPrime(g)==false);
		
		
	}

}

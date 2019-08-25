package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Ship;

class JShip {
	
	private Ship ship;

	
	void Escenario1() {
		ship= new Ship(2);
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
		ship.setPrime(a);
		assertTrue(ship.isPrime()==true);
		ship.setPrime(b);
		assertTrue(ship.isPrime()==true);
		ship.setPrime(c);
		assertTrue(ship.isPrime()==false);
		ship.setPrime(d);
		assertTrue(ship.isPrime()==true);
		ship.setPrime(e);
		assertTrue(ship.isPrime()==false);
		ship.setPrime(f);
		assertTrue(ship.isPrime()==true);
		ship.setPrime(g);
		assertTrue(ship.isPrime()==false);
		
		
	}

}

package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BattleField;

class Battlefield_Test {

	private BattleField bt;
	
	private int expected;
	
	void setUp1() {
		
		bt = new BattleField();
		
		int m = 2, n = 3;
		int[] numbers = new int[m*n];
		
		numbers[0] = 1;	numbers[1] = 2; numbers[2] = 3;
		numbers[3] = 4;	numbers[4] = 5; numbers[5] = 6;		
		
		bt.createShips(numbers, m, n);
		
		m = 3; n = 2;
		
		numbers = new int[m*n];
		
		numbers[0] = 5;	numbers[1] = 1;
		numbers[2] = 1;	numbers[3] = 0;	
		numbers[4] = 2; numbers[5] = 3;	
		
		bt.createShips(numbers, m, n);		
	}
	
	void setUp2() {
		
		bt = new BattleField();
		
		int m = 4, n = 5;
		
		bt.createShips(m, n);
		
		m = 5; n = 7; 
		
		bt.createShips(m, n);
		
		for(int k = 0; k < m; k++) {
			expected += bt.getMatrices().get(0)[0][k] * bt.getMatrices().get(1)[k][0];
		}
	}
	
	@Test
	void testMultiplicationOne() {
		
		setUp1();
		
		bt.MultiplationOne(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(13, bt.getDefinitive()[0][0]);
		assertEquals(10, bt.getDefinitive()[0][1]);
		assertEquals(37, bt.getDefinitive()[1][0]);
		assertEquals(22, bt.getDefinitive()[1][1]);
		
		
		setUp2();
		
		bt.MultiplationOne(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(expected, bt.getDefinitive()[0][0]);
		
	}
	
	@Test
	void testMultiplicationTwo() {
		
		setUp1();
		
		bt.MultiplationTwo(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(13, bt.getDefinitive()[0][0]);
		assertEquals(10, bt.getDefinitive()[0][1]);
		assertEquals(37, bt.getDefinitive()[1][0]);
		assertEquals(22, bt.getDefinitive()[1][1]);
		

		setUp2();
		
		bt.MultiplationTwo(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(expected, bt.getDefinitive()[0][0]);
		
	}
	
	@Test
	void testMultiplicationThree() {
		
		setUp1();
		
		bt.MultiplationThree(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(13, bt.getDefinitive()[0][0]);
		assertEquals(10, bt.getDefinitive()[0][1]);
		assertEquals(37, bt.getDefinitive()[1][0]);
		assertEquals(22, bt.getDefinitive()[1][1]);
		
		setUp2();

		bt.MultiplationThree(bt.getMatrices().get(0), bt.getMatrices().get(1));
		
		assertEquals(expected, bt.getDefinitive()[0][0]);
		
	}
}

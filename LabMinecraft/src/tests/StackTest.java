package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import stack.Stack;

class StackTest {

	private Stack<Integer> stack;
	
	void setUp() throws Exception {		
		stack = new Stack<>();		
	}

	@Test
	void test() throws Exception{
		
		setUp();
	
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		assertFalse(stack.isEmpty());
		
		assertEquals(1, stack.pop());
		assertEquals(2, stack.pop());
		
		assertEquals(3, stack.top());		
		assertEquals(3, stack.pop());
		
		assertTrue(stack.isEmpty());
	}

}

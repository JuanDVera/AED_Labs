package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import queue.Queue;

class QueueTest {

	private Queue<Integer> queue;
	
	void setUp() throws Exception {		
		queue = new Queue<>();		
	}

	@Test
	void test() throws Exception{
		
		setUp();
	
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		assertFalse(queue.isEmpty());
		
		assertEquals(3, queue.poll());
		assertEquals(2, queue.poll());
		
		assertEquals(1, queue.head());
		assertEquals(1, queue.poll());
		
		assertTrue(queue.isEmpty());
	}

}

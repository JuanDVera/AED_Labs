package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hashTable.*;

class HashTableOATest {
	
	private HashTableOA<Integer, Integer> T;
	private HashTableOA<Integer, String> T2;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void setUp() throws Exception {		
		
		T = new HashTableOA(5);		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void setUp2() throws Exception {
				
		T2 = new HashTableOA(5);	
		
		T2.add(1512, "Galleta");
		T2.add(235, "Mi");
		T2.add(664, "mamá");
		T2.add(23, "me");
		T2.add(987, "mima");		
	}
	
	@Test
	void testAdd() throws Exception {
		
		setUp();
		
		assertEquals(0, T.size());
		
		T.add(2342334, 3);
		T.add(24, 1);
		T.add(6434, 7);
		
		assertEquals(3, T.size());
		
		T.add(552, 5);
		T.add(6211, 2);
		
		assertEquals(5, T.size());
		try {
			T.add(51561, 653);
		} catch (HashException e) {
			assertEquals("No Room Left",  e.getMessage());
		}
	}
	
	@Test
	void testGet() throws Exception {
		
		setUp2();
		
		assertEquals("Galleta", T2.get(1512));
		
		try {
			assertEquals("eo", T2.get(5135266));
		
		} catch(HashException e) {
			assertEquals("The item does not exist", e.getMessage());
		}		
	}
	
	@Test
	void testDelete() throws Exception {
		
		setUp();
				
		try {			
			T.delete(8248);	
		
		} catch(HashException e) {
			assertEquals("The Table is Empty", e.getMessage());
		}
		
		setUp2();
				
		try {
			T2.delete(2535);
		
		} catch(HashException e) {
			assertEquals("The item does not exist", e.getMessage());
		}
			
		// this exist and is going to be deleted successfully
		T2.delete(1512);
		
		try {
			T2.get(1512);
		
		} catch(HashException e) {
			assertEquals("The item does not exist", e.getMessage());
		}
	}
}

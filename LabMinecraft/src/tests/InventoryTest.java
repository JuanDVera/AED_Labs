package tests;

import static org.junit.jupiter.api.Assertions.*;
import model.Inventory;
import stack.Stack;

import org.junit.jupiter.api.Test;

class InventoryTest {
	
	Inventory inv;
	
	void setUp1() {		
		inv = new Inventory();
	}
	
	void setUp2() throws Exception {
		
		setUp1();
		
		inv.addItem("roca", 34);				
		inv.addItem("lana", 2);		
		inv.addItem("tierra", 60);			
		inv.addItem("roca", 60);				
		inv.addItem("tierra", 28);			
		inv.addItem("lana", 18);
	}
	
	void setUp3() throws Exception {
		
		setUp2();
		
		//roca 64 & 30, tierra 64 & 24, lana 20
		
		inv.addItem("roca", 64 * 2); // 64,64,64,30
		inv.addItem("madera", 96);//64, 32
	}
	
	void setUp4() throws Exception{
		
		setUp3();
		
		inv.addBar("madera");//64, 32
		inv.addBar("roca");// 64,64,64,30
	}

	@Test
	void testAddItem() throws Exception{
		
		setUp1();
		
		// different types are added correctly
		
		inv.addItem("roca", 34);
		assertEquals(35, inv.getSlots());			
		
		inv.addItem("lana", 2);
		
		inv.addItem("tierra", 60);
		assertEquals(33, inv.getSlots());		
		
		// same type added

		inv.addItem("roca", 60);
		assertEquals(32, inv.getSlots());		
		// 64 & 30
		
		inv.addItem("tierra", 28);
		assertEquals(31, inv.getSlots());		
		// 64 & 24
		
		inv.addItem("lana", 18);
		assertEquals(31, inv.getSlots());		
		// 20
	}
	
	@Test
	void testDeleteItem() throws Exception{
		
		setUp2();
		
		inv.deleteItem("roca", 20);
		inv.deleteItem("lana", 18);
		
		assertEquals(31, inv.getSlots());
		
		inv.deleteItem("tierra", 24);
		inv.deleteItem("roca", 64);
		
		assertEquals(33, inv.getSlots());		
	}

	@Test
	void testAddBar() throws Exception{
		
		setUp3();
		
		inv.addBar("madera");//64, 32
		inv.addBar("roca");// 64,64,64,30
		
		Stack<Integer> stack = inv.getFastAccessBars().head();
		
		assertEquals(64, stack.pop());
		assertEquals(32, stack.pop());
		
		inv.getFastAccessBars().poll();
		stack = inv.getFastAccessBars().poll();
		
		assertEquals(64, stack.pop());
	}
	
	@Test
	void testRemove() throws Exception{
		
		setUp4();
		
		// madera 64,32
		
		inv.remove(60);
		
		int left = inv.getFastAccessBars().head().top();
		
		assertEquals(4, left);
		
		inv.remove(6);
		
		left = inv.getFastAccessBars().head().top();
		
		assertEquals(30, left);		
	}
	
	@Test
	void testChange() throws Exception{
		
		setUp4();
		
		// roca 64,64,64,30
		
		inv.change();
		inv.getFastAccessBars().head().pop();
		inv.getFastAccessBars().head().pop();
		inv.getFastAccessBars().head().pop();
		
		assertEquals(30, inv.getFastAccessBars().head().top());
	}
}

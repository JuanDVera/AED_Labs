package model;

import hashTable.HashException;
import hashTable.HashTableOA;
import nodes.LinkedNode;
import queue.Queue;
import stack.Stack;

public class Inventory {
	
	public static final String AS = "./pics/AS.png";
	public static final String AW = "./pics/AW.png";
	public static final String B = "./pics/B.png";
	public static final String BC = "./pics/BC.png";
	public static final String C = "./pics/C.png";
	public static final String CA = "./pics/CA.png";
	public static final String D = "./pics/D.png";
	public static final String G = "./pics/G.png";
	public static final String GB = "./pics/GB.png";
	public static final String GM = "./pics/GM.png";
	public static final String L = "./pics/L.png";
	public static final String LL = "./pics/LL.png";
	public static final String P = "./pics/P.png";
	public static final String RS = "./pics/RS.png";
	public static final String RW = "./pics/RW.png";
	public static final String S = "./pics/S.png";
	public static final String SB = "./pics/SB.png";
	public static final String SM = "./pics/SM.png";
	public static final String SP = "./pics/SP.png";
	public static final String T = "./pics/T.png";
	public static final String TR = "./pics/TR.png";
	public static final String TRS = "./pics/TRS.png";
	public static final String WC = "./pics/WC.png";
	public static final String YD = "./pics/YD.png";
	
	private HashTableOA<String, LinkedNode<Integer>> inventory;
	
	private Queue<Stack <Integer>> fastAccessBars;
	
	private int slots;
	
	public Inventory() {
		
		inventory = new HashTableOA<String, LinkedNode<Integer>>(4*9);
		fastAccessBars = new Queue<Stack<Integer>>();		
		slots = 36;
	}
	
	public void addItem(String key, int cant) throws Exception{
		
		if(slots < 37) {
			
			int left = cant;
			
			while (left > 0) {
				
				try {
					LinkedNode<Integer> node = inventory.get(key);
					Integer value = node.getElement();
					
					if(value.compareTo(64) < 0) {
						Integer x = value + left;
						if(x.compareTo(65) < 0) {
							node.setElement(x);
							left = 0;
						}
						else {
							x = 64 - node.getElement();
							node.setElement(64);
							left -= x;
						}
					}else {
						
						if(left < 65) {
							LinkedNode<Integer> aux = new LinkedNode<Integer>(left);
							aux.setNext(node);
							inventory.delete(key);
							inventory.add(key, aux);
							left  = 0;
							slots--;						
						} else {
							left -= 64;
							LinkedNode<Integer> aux = new LinkedNode<Integer>(64);
							aux.setNext(node);
							inventory.delete(key);
							inventory.add(key, aux);
							slots--;	
						}
						
					}
					
				} catch (HashException e) {
					
					if(left < 65) {
						
						LinkedNode<Integer> node = new LinkedNode<Integer>(left);
						inventory.add(key, node);
						
						slots--;
						left-=64;
					}else {
						LinkedNode<Integer> node = new LinkedNode<Integer>(64);
						inventory.add(key, node);
						
						slots--;
						left-=64;
					}
				}
			}				
		}
	}
	
	public void deleteItem(String key, int cantidad) throws Exception{
		
		int left = cantidad;
		
		while(left > 0) {
			
			LinkedNode<Integer> node = inventory.get(key);
			
			int toDelete = node.getElement();
			
			if(left < toDelete) {
				node.setElement(node.getElement() - left);
				left -= toDelete;
				
			}else if(left == toDelete) {
				left = 0;
				
				node = node.getNext();				
				inventory.delete(key);
				if(node != null)
					inventory.add(key, node);
				slots++;
				
			}else {
				left -= toDelete;
				
				node = node.getNext();				
				inventory.delete(key);
				if(node != null)
					inventory.add(key, node);
				slots++;					
			}
			
			if(node.getElement().compareTo(0) < 1) {
				node = node.getNext();				
				inventory.delete(key);
				if(node != null)
					inventory.add(key, node);
				slots++;	
			}				
		}		
	}
	
	public Queue <Stack<Integer>> getFastAccessBars(){
		return fastAccessBars;
	}
	
	public void addBar(String key) throws HashException {
		
		Stack<Integer> stack = new Stack<Integer>();
		LinkedNode<Integer> node = inventory.get(key);
		
		stack.push(node.getElement());
		
		while(node.getNext() != null) {
			stack.push(node.getNext().getElement());
			node  = node.getNext();
		}
		
		inventory.delete(key);
		
		fastAccessBars.add(stack);
	}
	
	public void remove(int cant) {
		
		Stack<Integer> stack = fastAccessBars.head();
		
		if(stack != null) {
			
			int left = cant;
			
			while(left > 0) {
				
				int x = stack.pop();
				
				if(left < x) {
					stack.push(x - left);
					left = 0;
					
				}else if(left > x) {				
					left -= x;
					
				}else
					left = 0;			
			}					
		}
	}
	
	public void change() {		
		fastAccessBars.add(fastAccessBars.poll());		
	}

	public int getSlots() {
		return slots;
	}

}

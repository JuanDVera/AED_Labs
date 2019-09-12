package queue;

import nodes.LinkedNode;
import queue.QueueInterface;

public class Queue <T> implements QueueInterface<T>{

	private LinkedNode<T> head;
	private LinkedNode<T> last;
	private int size;
	
	public void add(T element){
		
		LinkedNode <T> newNode = new LinkedNode<>(element);
		
		if(head == null) {
			head = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}	
		size++;		
	}


	public T poll() {
		
		verificarInvariante();
		LinkedNode<T> node = head;
		head = head.getNext();		
		size--;
		
		return node.getElement();
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public T head() {
		return head.getElement();
	}

	private void verificarInvariante() {
		assert(size > 0);
	}
	
	public int size() {
		return size;
	}
	
}

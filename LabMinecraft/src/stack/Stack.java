package stack;

import nodes.LinkedNode;;

public class Stack<T> implements StackInterface<T> {
	
	private LinkedNode<T> top;
	private int size;

	public void push(T element) {
		LinkedNode<T> newNode = new LinkedNode<T>(element);
		newNode.setNext(top);
		top = newNode;
		size++;
	}

	public T pop() {
		verificarInvariante();
		LinkedNode<T> node = top;
		top = node.getNext();
		size--;
		return node.getElement();
	}

	public boolean isEmpty() {
		return top == null;
	}

	public T top() {
		return top.getElement();
	}

	public int size() {
		return size;
	}
	
	private void verificarInvariante(){
		assert(size > 0);
	}
}

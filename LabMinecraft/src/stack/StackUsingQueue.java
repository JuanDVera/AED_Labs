package stack;

import queue.*;

public class StackUsingQueue <T> implements StackInterface<T>{

	private Queue<T> contenedor;
	private Queue<T> consulta;
	private int size;
	
	public StackUsingQueue() {
		contenedor = new Queue<>();
		consulta = new Queue<>();
		size = 0;
	}
		
	public void push(T elemento) {
		contenedor.add(elemento);
		size++;
	}

	
	public T pop() {
		
		if(!isEmpty()) {
			for(int i = contenedor.size(); i > 1; i--) {
				consulta.add(contenedor.poll());
			}
			T nodo = consulta.poll();
			for(int i = consulta.size(); i > 0; i--) {
				contenedor.add(consulta.poll());
			}
			size--;
			return nodo;
		}
		return null;
	}

	
	public boolean isEmpty() {
		return contenedor.isEmpty();
	}

	
	public T top() {
		if(!isEmpty()) {
			for(int i = contenedor.size(); i > 1; i--) {
				consulta.add(contenedor.poll());
			}
			T nodo = consulta.poll();
			consulta.add(nodo);
			for(int i = consulta.size(); i > 0; i--) {
				contenedor.add(consulta.poll());
			}
			return nodo;
		}
		return null;
	}

	public int size() {
		return this.size;
	}

}

package queue;

import stack.*;

public class QueueUsingStack<T> implements QueueInterface<T> {
	
	private Stack<T> contenedor;
	private Stack<T> consulta;
	private int size;
	
	public QueueUsingStack(){
		contenedor = new Stack<T>();
		consulta = new Stack<T>();
		size = 0;
	}

	public void add(T elemento) {
		contenedor.push(elemento);
		size++;
	}

	public T poll(){
		if(!isEmpty()){
			for(int i = contenedor.size(); i > 1; i--){
				consulta.push(contenedor.pop());
			}
			T nuevo = contenedor.pop();
			for(int i = consulta.size(); i > 0; i--){
				contenedor.push(consulta.pop());
			}
			size--;
			return nuevo;
		}
		return null;
	}

	public boolean isEmpty() {
		return contenedor.isEmpty();
	}

	public T head() {
		if(!isEmpty()){
			for(int i = contenedor.size(); i > 1; i--){
				consulta.push(contenedor.pop());
			}
			T nuevo = contenedor.top();
			for(int i = consulta.size(); i > 0; i--){
				contenedor.push(consulta.pop());
			}
			return nuevo;
		}
		return null;
	}

	public int size() {
		return size;
	}
	
}

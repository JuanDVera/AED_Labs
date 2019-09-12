package nodes;

public class LinkedNode <E>{

	private LinkedNode<E> next;
	private E element;
	
	public LinkedNode(E element){
		this.element = element;
	}
	
	public E getElement(){
		return element;
	}
	
	public void setElement(E elemento){
		this.element = elemento;
	}
	
	public LinkedNode<E> getNext(){
		return next;
	}
	
	public void setNext(LinkedNode<E> next){
		this.next = next;
	}
	
}

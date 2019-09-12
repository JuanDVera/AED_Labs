package nodes;

public class DoubleLikedNode <E> extends LinkedNode<E>{

	private DoubleLikedNode <E> previous;
	
	public DoubleLikedNode(E element) {
		super(element);
	}
	
	public DoubleLikedNode<E> getPrevious(){
		return previous;
	}
	
	public void setPrevious(DoubleLikedNode <E> previous){
		this.previous = previous;
	}
	
}

package nodes;

public class LinkedPairNode <K,V> extends PairNode<K,V>{
	
	private LinkedPairNode<K,V> next;

	public LinkedPairNode(K key, V value) {
		super(key, value);
	}

	
	public LinkedPairNode<K,V> getNext(){
		return next;
	}
	
	public void setNext(LinkedPairNode<K,V> next){
		this.next = next;
	}
}

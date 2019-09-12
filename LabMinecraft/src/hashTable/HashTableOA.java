package hashTable;

import nodes.*;

public class HashTableOA <K,V> implements InterHashTable<K,V>{
	
	private LinkedPairNode<K,V>[] T;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HashTableOA(int size){		
		T = (LinkedPairNode<K,V>[])new LinkedPairNode[size];		
	}
	
	@Override
	public void add(K key, V value)throws HashException {
		
		if(size != T.length) {
			
			boolean done = false;
			
			for(int i = 0; i < T.length && !done; i++) {
				
				int index = (hashNumberM(key) + (i * hashNumberD(key))) % T.length;
				
				if(T[index] == null) {
					
					T[index] = (LinkedPairNode<K,V>) new LinkedPairNode<>(key, value);
					size++;
					done = true;
				}
			}
			
		}else 
			throw new HashException(101);
		
	}
	
	@Override
	public V get(K key) throws HashException{

		V value = null;
		boolean done = false;
		
		for(int i = 0; i < T.length && !done; i++) {
			
			int index = (hashNumberM(key) + (i * hashNumberD(key))) % T.length;
			
			if(T[index] != null) {
				if(((Integer)T[index].getKey()).compareTo((Integer)key) == 0) {
					value = T[index].getValue();
					done = true;
				}
			}				
		}					
				
		if(value == null)
			throw new HashException(102);	 
		
		return value;
	}

	@Override
	public void delete(K key) throws HashException {

		if(size == 0)
			throw new HashException(103);
		
		boolean done = false;
		
		for(int i = 0; i < T.length && !done; i++) {
			
			int index = (hashNumberM(key) + (i * hashNumberD(key))) % T.length;
			
			if(T[index] != null) {	
				
				if(((Integer)T[index].getKey()).compareTo((Integer)key) == 0) {
					T[index] = null;
					size--;
					done = true;
				}
			}				
		}
		
		if(!done)
			throw new HashException(102);
				
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int hashNumberM(K key) {		
		double a = (Math.sqrt(5) - 1) / 2;		
		return (int)(T.length * ((a * (int)key)%1));		
	}
	
	public int hashNumberD(K key) {
		return (int)key % T.length;
	}
	
	public int hashString(K key) {
		char k = 0;
		for(int i = 0; i < key.toString().length(); i++){
			k ^= key.toString().charAt(i);
		}
		int index = (int)(size * ((k * ((Math.sqrt(5)-1)/2)) % 1));
		if(index < 0){
			index = index * -1;
		}
		return index;
	}
}

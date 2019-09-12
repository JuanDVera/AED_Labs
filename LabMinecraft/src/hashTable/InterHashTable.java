package hashTable;

public interface InterHashTable<K, V> {
		
	public void add(K key, V value)throws HashException;
	
	public V get(K key) throws HashException;
	
	public void delete(K key) throws HashException;
	
	public int size();
	
	public int hashNumberM(K key);
	
	public int hashNumberD(K key);
	
	public int hashString(K key);
	
	public boolean isEmpty();

}

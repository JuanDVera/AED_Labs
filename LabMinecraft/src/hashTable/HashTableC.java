package hashTable;

import nodes.LinkedPairNode;

public class HashTableC<K, V> implements InterHashTable<K, V>{
	
	private LinkedPairNode<K, V>[] T;
	private int size;
	private int keys;

	@SuppressWarnings("unchecked")
	public HashTableC(int size){
		this.size = size;
		keys = 0;
		T = new LinkedPairNode[size];
	}
	
	/**
	 * 
	 * @param clave
	 * @param valor
	 */
	public void add(K key, V value) {
//		LinkedPairNode<K, V> elemnt = new LinkedPairNode<K, V>(key, value);
//		int index = hash(key);
//		if(tabla[pos] == null){
//			tabla[pos] = item;
//			claves++;
//		}else{
//			Item<k, v> itemOtro = tabla[pos];
//			boolean agregar = true;
//			if(tabla[pos].darClave().equals(clave)){
//				item.cambiarSiguiente(itemOtro.darSiguiente());
//				tabla[pos] = item;
//				agregar = false;
//			}
//			while(itemOtro.darSiguiente() != null && agregar){
//				if(itemOtro.darSiguiente().darClave().equals(clave)){
//					item.cambiarSiguiente(itemOtro.darSiguiente().darSiguiente());
//					itemOtro.cambiarSiguiente(item);
//					agregar = false;
//				}else{
//					itemOtro = itemOtro.darSiguiente();
//				}
//			}
//			if(agregar){
//				itemOtro.cambiarSiguiente(item);
//				claves++;
//			}
//		}
//		
	}

	public V get(K clave) {
//		int pos = hash(clave);
//		if(tabla[pos] == null){
//			return null;
//		}else{
//			Item<k, v> item = tabla[pos];
//			while(item != null){
//				if(item.darClave().equals(clave)){
//					return item.darValor();
//				}else{
//					item = item.darSiguiente();
//				}
//			}
//		}
		return null;
	}

	public void delete(K clave) {
//		int pos = hash(clave);
//		if(tabla[pos] != null){
//			Item<k, v> item = tabla[pos];
//			if(tabla[pos].darClave().equals(clave)){
//				tabla[pos] = tabla[pos].darSiguiente();
//				claves--;
//			}else{
//				while(item.darSiguiente() != null){
//					if(item.darSiguiente().darClave().equals(clave)){
//						item.cambiarSiguiente(item.darSiguiente().darSiguiente());
//						claves--;
//					}else{
//						item = item.darSiguiente();
//					}
//				}
//			}
//		}
	}

	public int size() {
		return keys;
	}

	public boolean isEmpty() {
		return keys == 0;
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

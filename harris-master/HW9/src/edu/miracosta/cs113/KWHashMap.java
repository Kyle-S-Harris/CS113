package edu.miracosta.cs113;

/**
 * @author Kyle Harris
 * @version 1.0
 * */

public interface KWHashMap<K, V>
{
	V get(Object key);
	
	V put(K key, V value);
	
	V remove(Object key);
	
	int size();
	
	boolean isEmpty();
}

package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */

public interface SearchTree<E>
{
	public boolean add(E data);
	
	public boolean contains(E data);
	
	public E find(E data);
	
	public E delete(E data);
	
	public boolean remove(E data);
}

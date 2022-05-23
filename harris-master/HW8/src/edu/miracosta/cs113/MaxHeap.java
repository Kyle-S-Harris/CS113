package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */
import java.util.Comparator;

public class MaxHeap<E> extends Heap<E>
{	
	//DEFAULT CONSTRUCTOR
	public MaxHeap()
	{
		super();
	}
	
	//FULL CONSTRUCTOR
	public MaxHeap(Comparator<E> comparator)
	{
		super(comparator);
	}

	/**
	 * @param left The left object to be compared to right
	 * @param right The right item to be compared to left
	 * @return left.compareTo(right) - (-1) The max heap comparison of left to right
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(E left, E right) 
	{
		return((Comparable<E>) left).compareTo(right) - (-1);
	}
}
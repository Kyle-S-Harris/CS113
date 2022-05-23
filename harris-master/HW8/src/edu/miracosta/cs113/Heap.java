package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */
import java.util.Comparator;

public abstract class Heap<E>
{
	private KWPriorityQueue<E> queue;
	
	//DEFAULT CONSTRUCTOR
	public Heap()
	{
		queue = new KWPriorityQueue<>();
	}
	
	//FULL CONSTRUCTOR
	public Heap(Comparator<E> comp)
	{
		queue = new KWPriorityQueue<>(comp);
	}
	
	/**
	 * @param left The left object to be compared to right
	 * @param right The right item to be compared to left
	 * */
	public abstract int compare(E left, E right);
	
	/**
	 * @param queue The priority queue to be set
	 * */
	public void setQueue(KWPriorityQueue<E> queue)
	{
		this.queue = queue;
	}
	
	/**
	 * @return queue The priority queue to be retrieved
	 * */
	public KWPriorityQueue<E> getQueue()
	{
		return this.queue;
	}
}

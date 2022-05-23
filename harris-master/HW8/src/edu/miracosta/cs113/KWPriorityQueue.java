package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class KWPriorityQueue<E> extends AbstractQueue<E> implements Queue<E>
{
	
	private ArrayList<E> theData;
	private Comparator<E> comparator;
	
	//DEFAULT CONSTRUCTOR
	public KWPriorityQueue()
	{
		this.theData = new ArrayList<E>();
		this.comparator = null;
	}
	
	//FULL CONSTRUCTOR
	public KWPriorityQueue(Comparator<E> comparator)
	{
		this.theData = new ArrayList<E>();
		this.comparator = comparator;
	}
	
	/**
	 * @param left The left object to be compared to right
	 * @param right The right item to be compared to left
	 * @return comparator.compare(left, right) if comparator is null, compares left and right with comparator
	 * @return left.compareTo(right) otherwise, Compares left and right with compareTo method
	 * */
	@SuppressWarnings("unchecked")
	private int compare(E left, E right)
	{
		if(this.comparator != null)
		{
			return comparator.compare(left,  right);
		}
		else
		{
			return((Comparable<E>) left).compareTo(right);
		}
	}
	
	/**
	 * @param parent The first value in the ArrayList
	 * @param minChild The lowest child value in the ArrayList
	 * */
	private void swap(int parent, int minChild)
	{
		E temp;
		temp = theData.get(parent);
		theData.set(parent, this.theData.get(minChild));
		theData.set(minChild, temp);
	}

	/**
	 * @param item The item to be inserted into the ArrayList
	 * @return true When method processes have completed and the item was added to the ArrayList
	 * */
	@Override
	public boolean offer(E item) 
	{
		this.theData.add(item);
		int child, parent;
		child = this.theData.size() - 1;
		parent = (child - 1) / 2;
		while(parent >= 0 && this.compare(this.theData.get(parent), this.theData.get(child)) > 0)
		{
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}
	
	/**
	 * @throws NoSuchElementException if the ArrayList is empty
	 * @return poll() Calls poll method which returns and removes the first object from ArrayList
	 * */
	public E remove() throws NoSuchElementException
	{
		if(this.theData.isEmpty())
		{
			throw new NoSuchElementException();
		}
		return this.poll();
	}

	/**
	 * @return null If the ArrayList is empty
	 * @return return result if the ArrayList size is 1 or when all the method processes are complete, result is the data at the first position of ArrayList
	 * */
	@Override
	public E poll() 
	{
		int parent;
		boolean isTrue;
		if(isEmpty())
		{
			return null;
		}
		
		E result;
		result = this.theData.get(0);
		if(this.theData.size() == 1)
		{
			this.theData.remove(0);
			return result;
		}
		
		this.theData.set(0, this.theData.remove(this.theData.size() - 1));
		parent = 0;
		isTrue = true;
		
		while(isTrue)
		{
			int leftChild, rightChild, minChild;
			leftChild = 2 * parent + 1;
			if(leftChild >= this.theData.size())
			{
				isTrue = false;
			}
			else
			{
				rightChild = leftChild + 1;
				minChild = leftChild;
				
				if(rightChild < this.theData.size() && this.compare(this.theData.get(leftChild), this.theData.get(rightChild)) > 0)
				{
					minChild = rightChild;
				}
				
				if(this.compare(this.theData.get(parent), this.theData.get(minChild)) > 0)
				{
					this.swap(parent, minChild);
					parent = minChild;
				}
				else
				{
					isTrue = false;
				}
			}
		}
		return result;
	}
	
	/**
	 * @return null If the ArrayList is empty
	 * @return theData.get(0) The data at the first position of the ArrayList
	 * */
	@Override
	public E peek() 
	{
		if(this.theData.isEmpty())
		{
			return null;
		}
		return this.theData.get(0);
	}
	
	/**
	 * @throws NoSuchElementException If the ArrayList is empty
	 * @return theData.get(0) The data at the first position of the ArrayList
	 * */
	public E element() throws NoSuchElementException
	{
		if(this.theData.isEmpty())
		{
			throw new NoSuchElementException();
		}
		return this.theData.get(0);
	}

	/**
	 * @return theData.iterator() The iterator method from ArrayList class
	 * */
	@Override
	public Iterator<E> iterator() 
	{
		return this.theData.iterator();
	}

	/**
	 * @return theData.size() The size of the ArrayList
	 * */
	@Override
	public int size() 
	{
		return this.theData.size();
	}
}

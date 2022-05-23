/**
 * @author Kyle Harris
 * @version 1.0
 * */
package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<E>
{
	 private static final int INITIAL_CAPACITY = 10;
	 private ArrayList<E> theData;
	 
	//CONSTRUCTOR
	public ArrayStack()
	{
		theData = new ArrayList<>(INITIAL_CAPACITY);
	}
	
	/** @param obj The object to be added the ArrayList stack
	 *  @return obj The object that was added to the ArrayList stack */
	public E push(E obj) 
	{
		theData.add(obj);
		return obj;
	}
	
	/** @throws EmptyStackException when the ArrayList stack is empty
	 *  @return Removes the object from the top of the ArrayList stack */
	public E pop()
	{
		if(theData.isEmpty())
		{
			throw new EmptyStackException();
		}
		return theData.remove(theData.size() - 1);
	}
	
	/** @throws EmptyStackException when the ArrayList stack is empty
	 *  @return Gets the object from the top of the ArrayList stack */
	public E peek()
	{
		if(theData.isEmpty())
		{
			throw new EmptyStackException();
		}
		return theData.get(theData.size() - 1);
	}
	
	/** @return True if the ArrayList stack is empty, false if it isn't */
	public boolean empty()
	{
		return theData.isEmpty();
	}
	
}

/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Import packages for List, ListIterator, and NoSuchElementException.
 * 2. Create class of type E called DoubleLinkedList which implements List of type E.
 * 3. Make instance Node<E> for head and tail and instance var int for size, initialize all to null or 0;
 * 4. Create private static inner class Node<E> and declare local variables of E data, Node<E> next and prev. 
 * Build default and full constructors as well.
 * 5. Create private class ListIter which implements ListIterator<E>. Declare local Node<E> vars for nextItem and LastItemReturned and int for index.
 * Create all necessary methods and Override.
 * 6. Outside inner classes, implement all necessary methods of List and override.
 * 7. Test all methods built.
 */

package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E>
{
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		private Node(E data)
		{
			this.data = data;
			this.next = null;
			this.prev = null;
		} 
		
		private Node(E data, Node<E> next, Node<E> prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	//ListIter class
	private class ListIter implements ListIterator<E>
	{
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index = 0;
	
		/** @param i The index of the item to be referenced*/
		public ListIter(int i)
		{
			if(i < 0 || i > size)
			{
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			lastItemReturned = null;
			
			if(i == size)
			{
				index = size;
				nextItem = null;
			}
			else
			{
				nextItem = head;
				for(index = 0; index < i; index++)
				{
					nextItem = nextItem.next;
				}
			}
		}
		
		/** @param obj The item to be inserted */
		@Override
		public void add(E obj)
		{
			if(head == null)
			{
				head = new Node<E>(obj);
				tail = head;
			}
			else if(nextItem == head)
			{
				Node<E> newNode = new Node<E>(obj);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			}
			else if(nextItem == null)
			{
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			else
			{
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			size++;
			index++;
			lastItemReturned = null;
		}
	
		/**@return true if call to next will not throw an exception */
		@Override
		public boolean hasNext() 
		{
			return nextItem != null;
		}
	
		/**@return true if call to previous will not throw an exception */
		@Override
		public boolean hasPrevious() 
		{
			return (nextItem == null && size != 0) || nextItem.prev != null;
		}
	
		/** @return The next item in the list
		 *  @throws NoSuchElementException if there is no such object */
		@Override
		public E next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}
	
		/** @return The next index */
		@Override
		public int nextIndex() 
		{
			return index + 1;
		}
	
		/** @return The previous item in the list
		 *  @throws NoSuchElementException if there is no such object */
		@Override
		public E previous() 
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			if(nextItem == null)
			{
				nextItem = tail;
			}
			else
			{
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
	
		/** @return The previous index */
		@Override
		public int previousIndex() 
		{
			return index - 1;
		}
		
		/** @throws NoSuchElementException if there is no such object */
		@Override
		public void remove()
		{
			if(lastItemReturned == null)
			{
				throw new NoSuchElementException();
			}
			else if(size == 1 || !hasNext())
			{
				head = null;
			}
			else if(lastItemReturned.prev == null)
			{
				head = head.next;
			}
			else
			{
				nextItem.prev = lastItemReturned.prev;
				lastItemReturned.prev.next = lastItemReturned.next;
				size--;
				index--;
			}
		}
		
		/** @param obj The item to be inserted
		 *  @throws NoSuchElementException if there is no such object*/
		@Override
		public void set(E obj)
		{
			if(head == null || nextItem  == null) 
			{
				throw new NoSuchElementException();
			}
			nextItem.data = obj;
		}
	
	}//END ListIter
	
	//LIST INTERFACE METHODS 
	/** @param index The position at which the object is to be inserted
	 *  @param obj The object to be inserted
	 *  @throws IndexOutOfBoundsException if the index is out of range (i < 0 || i > size) */
	@Override
	public void add(int index, E obj)
	{
		listIterator(index).add(obj);
	}

	/** @param obj The object to be inserted 
	  * @return true */
	@Override
	public boolean add(E obj) 
	{
		listIterator(this.size - 1).add(obj);
		return true;
	}

	//Ignore
	@Override
	public boolean addAll(Collection<? extends E> arg0) 
	{
		//Auto-generated method stub
		return false;
	}

	//Ignore
	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) 
	{
		//Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{
		ListIterator<E> iterator = listIterator(0);
		while(iterator.hasNext())
		{
			iterator.next();
			iterator.remove();
		}
	}

	@Override
	public boolean contains(Object arg0) 
	{
		//Auto-generated method stub
		return false;
	}

	//Ignore
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/** @param index The position at which the object is to be inserted
	 *  @throws IndexOutOfBoundsException when the list is empty
	 *  @return The list object from the index parameter */
	@Override
	public E get(int index) 
	{
		return listIterator(index).next();
	}

	/** @param obj The object to be found
	 *  @return the index where the iterator is pointed if the object is found
	 *  @return -1 if the object is not found */
	@Override
	public int indexOf(Object obj) 
	{
	
		ListIter iterator = new ListIter(0);
		while(iterator.hasNext())
		{
			iterator.next();
			if(iterator.nextItem.data == obj)
			{
				return iterator.index;
			}
		}
		return -1; //This is what returns assuming an object was not found in the loop
	}
	

	/** @return true if head is null */
	@Override
	public boolean isEmpty() 
	{
		return head == null;
	}

	//Ignore
	@Override
	public Iterator<E> iterator() 
	{
		//Auto-generated method stub
		return null;
	}

	//Ignore
	@Override
	public int lastIndexOf(Object arg0) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/** @return new LisIter object at the head */
	@Override
	public ListIterator<E> listIterator() 
	{
		return new ListIter(0);
	}

	/**@param index The position at which the new ListIter is to be created
	 * @return new LisIter object at the specified index */
	@Override
	public ListIterator<E> listIterator(int index)
	{
		return new ListIter(index);
	}

	//Ignore
	@Override
	public boolean remove(Object arg0) 
	{
		//Auto-generated method stub
		return false;
	}

	/** @param index The position at which the object will be removed
	 *  @throws NullPointerException when the object at the index is not there
	 *  @return returnVal which is the position of the object that was removed */
	@Override
	public E remove(int index) 
	{
		ListIterator<E> iterator = listIterator(index);
		E returnVal = iterator.next();
		iterator.remove();
		return returnVal;
	}

	//Ignore
	@Override
	public boolean removeAll(Collection<?> arg0) 
	{
		//Auto-generated method stub
		return false;
	}

	//Ignore
	@Override
	public boolean retainAll(Collection<?> arg0) {
		//Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E obj)
	{
		ListIterator<E> iterator = listIterator(index);
		iterator.set(obj);
		return obj;
	}

	/** @return size of the list */
	@Override
	public int size()
	{
		return this.size;
	}
	
	//Ignore
	@Override
	public List<E> subList(int arg0, int arg1) {
		//Auto-generated method stub
		return null;
	}

	//Ignore
	@Override
	public Object[] toArray() {
		//Auto-generated method stub
		return null;
	}
	
	//Ignore
	@Override
	public <T> T[] toArray(T[] arg0) {
		//Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args)
	{
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		
		System.out.println("Let's add to the DoubleLinkedList!");
		list.add(0, "Hello World");
		list.add(1, "Gooddaayyy World");
		list.add(2, "Hallo World");
		list.add(3, "Blah World");
		list.add(4, "Meh World");
		list.add("Blaahhh");
		System.out.println("Is the list empty?: " + list.isEmpty());
		System.out.println("Now let's print all that! \n" + list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
		System.out.println("The size is: " + list.size());
		System.out.println("Let's remove the second item (position 1)! " + list.remove(1));
		System.out.println("The size is: " + list.size());
		System.out.println("The second item (position 1) is now: " + list.get(1));
		System.out.println("Let's set the first item to something else!");
		list.set(0, "Yaaaa");
		System.out.println("The first item is now: " + list.get(0));
		System.out.println("Blah World is at position " + list.indexOf("Blah World") + " (third item)");
		list.clear();
		System.out.println("Is the list empty now?: " + list.isEmpty());
	}
}

package edu.miracosta.cs113;

public class SingleLinkedList<E>
{
	private Node<E> head = null;
	private int size = 0;
	
	//NODE INNER CLASS
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		
		private Node(E data)
		{
			this.data = data;
			this.next = null;
		} 
		
		private Node(E data, Node<E> nodeRef)
		{
			this.data = data;
			this.next = nodeRef;
		}
	}
	
	//SETTER
	public E set(int index, E newItem)
	{
		/*if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}*/
		Node<E> node;
		E result;
		node = getNode(index);
		result = node.data;
		node.data = newItem;
		return result;
		
	}
	
	//GET METHODS
	private Node<E> getNode(int index)
	{
		Node<E> node = this.head;
		for(int i = 0; i < index && node != null; i++)
		{
			node = node.next;
		}
		return node;
	}
	
	public E get(int index)
	{
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}
	
	//ADD METHODS
	private void addFirst(E item)
	{
		this.head = new Node<>(item, head);
		this.size++;
	}
	
	private void addAfter(Node<E> node, E item)
	{
		Node<E> temp;
		temp = new Node<E>(item, node.next);
		node.next = temp;
		this.size++;
	}
	
	public void add(int index, E item)
	{
		if(index < 0 /*|| index > this.size*/)
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		
		if(index == 0)
		{
			this.addFirst(item);
		}
		else
		{
			Node<E> node;
			node = getNode(index - 1);
			this.addAfter(node, item);
		}
	}
	
	public boolean add(E item)
	{
		this.add(this.size, item);
		return true;
	}
	
	//REMOVE METHODS
	private E removeFirst()
	{
		if(this.head == null)
		{
			return null;
		}
		else
		{
			Node <E> temp;
			temp = this.head;
			this.head = this.head.next;
			this.size--;
			return temp.data;
		}
	}
	
	private E removeAfter(Node<E> node)
	{
		Node<E> temp;
		temp = node.next;
		if(temp != null)
		{
			node.next = temp.next;
			this.size--;
			return temp.data;
		}
		else
		{
			return null;
		}
	}
	
	//public E remove(int index)
	
	public int size()
	{
		return this.size;
	}
}

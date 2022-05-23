package edu.miracosta.cs113;
/**
 * @author Kyle Harris (with source code from Koffman and Wolfgang)
 * @version 1.0
 * */

import java.io.Serializable;

//import edu.miracosta.cs113.AVLTree.AVLNode;

public class RebalanceRight<E>{

	/**
	 * @author Kyle Harris
	 * */
	protected static class Node<E> implements Serializable
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		protected Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		} 
		
		/**
		 * @return toString The string of all instance variables of class Node
		 * */
		public String toString()
		{
			return this.data.toString();
		}
	}
	
	/**
	 * @author Koffman and Wolfgang
	 * */
	private static class AVLNode<E> extends Node<E> 
	{

	        /** Constant to indicate left-heavy */
	        public static final int LEFT_HEAVY = -1;
	        /** Constant to indicate balanced */
	        public static final int BALANCED = 0;
	        /** Constant to indicate right-heavy */
	        public static final int RIGHT_HEAVY = 1;
	        /** balance is right subtree height - left subtree height */
	        private int balance;

	        // Methods
	        /**
	         * Construct a node with the given item as the data field.
	         * @param item The data field
	         */
	        public AVLNode(E item) {
	            super(item);
	            balance = BALANCED;
	        }

	        /** @author Kyle Harris
	         * Return a string representation of this object.
	         * The balance value is appended to the contents.
	         * @return String representation of this object
	         */
	        public String toString() {
	            return String.format("%2d", balance) + ": " + super.toString();
	        }
	}

	/**
     * Method to rebalance right.
     * @author Kyle Harris
     * @pre localRoot is the root of an AVL subtree that is
     *      critically right-heavy.
     * @post Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
    {
    		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
    		
    		if(rightChild.balance < AVLNode.BALANCED)
    		{
    			AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
    			
    			if(rightLeftChild.balance < AVLNode.BALANCED)
    			{
    				rightChild.balance = AVLNode.RIGHT_HEAVY;
    				rightLeftChild.balance = AVLNode.BALANCED;
    				localRoot.balance = AVLNode.BALANCED;
    			}
    			else if(rightLeftChild.balance < AVLNode.BALANCED)
    			{
    				rightChild.balance = AVLNode.BALANCED;
    				rightLeftChild.balance = AVLNode.BALANCED;
    				localRoot.balance = AVLNode.LEFT_HEAVY;
    			}
    			else
    			{
    				rightChild.balance = AVLNode.BALANCED;
    				localRoot.balance = AVLNode.BALANCED;
    			}
    			localRoot.right = rotateRight(rightChild);
    		}
    		else
    		{
    			rightChild.balance = AVLNode.BALANCED;
    			localRoot.balance = AVLNode.BALANCED;
    		}
    		return (AVLNode<E>) rotateLeft(localRoot);
    }
	 // Methods
    /**
     * Method to perform a right rotation.
     * @author Koffman and Wolfgang
     * @pre  root is the root of a binary search tree.
     * @post root.right is the root of a binary search tree,
     *       root.right.right is raised one level,
     *       root.right.left does not change levels,
     *       root.left is lowered one level,
     *       the new root is returned.
     * @param root The root of the binary tree to be rotated
     * @return The new root of the rotated tree
     */
    protected Node<E> rotateRight(Node<E> root) 
    {
        Node<E> temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }
    
    /**
     * @author Kyle Harris
     * @param root The root of the binary tree to be rotated
     * @return The new root of the rotated tree
     * */
    protected Node<E> rotateLeft(Node<E> root)
    {
    		Node<E> temp = root.right;
    		root.right = temp.left;
    		temp.left = root;
    		return temp;
    }
}

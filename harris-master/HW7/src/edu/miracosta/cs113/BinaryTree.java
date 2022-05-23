/**@author Kyle Harris
 * @version 0.6.1*/

package edu.miracosta.cs113;

import java.io.*;

public class BinaryTree<E> implements Serializable
{
	protected static class Node<E> implements Serializable
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		private Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		} 
		
		/**@return data.toString() The toString() of Node*/
		public String toString()
		{
			return this.data.toString();
		}
	}
	
	protected Node<E> root;
	
	//CONSTRUCTORS
	public BinaryTree()
	{
		this.root = null;
	}
	
	
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		this.root = new Node<E>(data);
		if(leftTree != null)
		{
			this.root.left = leftTree.root;
		}
		else
		{
			this.root.left = null;
		}
		
		if(rightTree != null)
		{
			this.root.right = rightTree.root;
		}
		else
		{
			this.root.right = null;
		}
	}
	
	/*@return new BinaryTree of the left if the root is null and the left is null
	 *@return null otherwise**/
	public BinaryTree<E> getLeftSubtree()
	{
		if(this.root != null && this.root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		else
		{
			return null;
		}
	}
	
	/**@return new BinaryTree of the right if the root is null and the right is null
	  *@return null otherwise*/
	public BinaryTree<E> getRightSubtree()
	{
		if(this.root != null && this.root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}
	
	/**@return both the left and the right subtrees as null*/
	public boolean isLeaf()
	{
		return(this.root.left == null && this.root.right == null);
	}
	
	/**@return sb.toString The toString created from the preorder traversal*/
	public String toString()
	{
		StringBuilder sb;
		sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	
	/**@param node The node to begin the preorder traversal from
	 * @param depth The depth of the tree
	 * @param sb The built string of the traversal*/
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for(int i = 1; i < depth; i++)
		{
			sb.append(" ");
		}
		if(node == null)
		{
			sb.append("null\n");
		}
		else
		{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
}

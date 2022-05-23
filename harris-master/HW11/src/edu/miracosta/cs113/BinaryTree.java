package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */
import java.io.Serializable;

public class BinaryTree<E> implements Serializable
{
	protected Node<E> root;
	private int treeDepth = 0;
	private long numNodes = 0;
	
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
	
	public BinaryTree()
	{
		this.root = null;
		treeDepth = 0;
		numNodes = 0;
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
	
	/**
	 * @return BinaryTree<E>(root.left) The left of root of the new binary tree if root and left of root are not null
	 * @return null If previous isn't true
	 * */
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
	
	/**
	 * @return BinaryTree<E>(root.right) The right of root of the new binary tree if root and right root are not null
	 * @return null If previous isn't true
	 * */
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
	
	/**
	 * @return this.root.left == null && this.root.right == null The left and right of root at null
	 * */
	public boolean isLeaf()
	{
		return(this.root.left == null && this.root.right == null);
	}
	
	
	/**
	 * @return sb.toString + treeDepth + numNodes The StringBuilder results of the preorder traversal of the tree
	 * */
	public String toString()
	{
		treeDepth = 0;
		numNodes = 0;
		StringBuilder sb;
		sb = new StringBuilder();
		preOrderTraversal(root, 1, sb);
		return sb.toString() + "Tree depth: " + treeDepth + " \nNumber of nodes: " + numNodes;
	}
	
	/**
	 * @param node The current node of the tree
	 * @param depth The depth of the tree being traversed
	 * @param sb The StringBuilder object that contains the preorder tree output
	 * */
	private void preOrderTraversal(Node<E> node, int depth, StringBuilder sb)
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
			if(depth > treeDepth)
			{
				treeDepth = depth;
			}
			numNodes++;
			sb.append(node.toString() + "\n");
			preOrderTraversal(node.left, depth + 1, sb);
			preOrderTraversal(node.right, depth + 1, sb);
		}
	}
	
	/**
	 * @return sb.toString + treeDepth + numNodes The StringBuilder results of the inorder traversal of the tree
	 * */
	public String wrap()
	{
		treeDepth = 0;
		numNodes = 0;
		StringBuilder sb = new StringBuilder();
		inOrderTraversal(root, 1, sb);
		return sb.toString() + "\nTree depth: " + treeDepth + " \nNumber of nodes: " + numNodes;
	}
	
	/**
	 * @param node The current node of the tree
	 * @param depth The depth of the tree being traversed
	 * @param sb The StringBuilder object that contains the inorder tree output
	 * */
	private void inOrderTraversal(Node<E> node, int depth, StringBuilder sb)
	{
		if(node != null)
		{
			if(depth > treeDepth)
			{
				treeDepth = depth;
			}
			inOrderTraversal(node.left, depth + 1, sb);
			sb.append(depth + ": " + node.toString() + " -> ");
			inOrderTraversal(node.right, depth + 1, sb);
			numNodes++;
		}
	}
	
	
	
	
}

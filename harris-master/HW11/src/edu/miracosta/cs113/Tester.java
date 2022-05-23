package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create AVL and BST objects
 * 2. Add random numbers to both trees in for loop
 * 3. Print in order and pre-order traversal for both AVL and BST trees
 * */
public class Tester 
{
	public static void main(String[] args)
	{
		
		AVLTree<Long> avlTree = new AVLTree<Long>();
		BinarySearchTree<Long> bst = new BinarySearchTree<Long>();
		
		for(int i = 0; i < 20; i++) 
		{
			long num = (long) (Math.random() * 1000);
			avlTree.add(num);
			bst.add(num);
		}
		
		System.out.println("Printing in-order traversal of AVLTree: ");
		System.out.println(avlTree.wrap());
		System.out.println("\nPrinting pre-order traversal of AVLTree: ");
		System.out.println(avlTree.toString());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Printing in-order traversal of BST: ");
		System.out.println(bst.wrap());
		System.out.println("\nPrinting pre-order traversal of BST: ");
		System.out.println(bst.toString());
	}

}

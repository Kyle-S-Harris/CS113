/** 
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create main method in Lab8 class
 * 2. Create 2 new stacks and a queue
 * 3. Add specified numbers to the first stack
 * 4. Print top value of first stack
 * 5. Push stack1 values into stack 2, using a for loop
 * 6. Use another for loop to remove each value from stack2 and print for each iteration of the loop
 * */

package edu.miracosta.cs113;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Lab8
{
	public static void main(String[] args)
	{
		//Part 1
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		//Queue<String> newQueue = new LinkedList<String>();
		int size1, size2;
		
		stack1.add(-1);
		stack1.add(15);
		stack1.add(23);
		stack1.add(44);
		stack1.add(4);
		stack1.add(99);
		System.out.println("Top of stack 1: " + stack1.peek());
		
		//Part 2
		size1 = stack1.size();
		for(int i = 0; i < size1; i++)
		{
			stack2.push(stack1.pop());
		}
		
		//Part 3
		System.out.println("Removing and printing from stack 2: ");
		size2 = stack2.size();
		for(int i = 0; i < size2; i++)
		{
			System.out.println(stack2.pop());
		}
		
	}
}

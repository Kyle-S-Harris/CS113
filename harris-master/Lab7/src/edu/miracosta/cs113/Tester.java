package edu.miracosta.cs113;

//Thoroughly tests all methods of ArrayStack class
public class Tester 
{
	public static void main(String[] args)
	{
		ArrayStack<String> myStack = new ArrayStack<String>();
		{
			myStack.push("Noob");
			myStack.push("Blah");
			myStack.push("Shoot");
			myStack.push("Bleh");
			myStack.push("Boom");
			
			System.out.println(myStack.empty());
			System.out.println(myStack.peek());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.pop());
			System.out.println(myStack.peek());
			System.out.println(myStack.pop());
			System.out.println(myStack.empty());
			System.out.println(myStack.pop());
			System.out.println(myStack.empty());
		}
	}
}

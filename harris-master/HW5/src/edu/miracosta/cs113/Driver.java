package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create Driver class
 * 2. Create 2 new ArrayStack objects of type Character 
 * 3. Declare variables as needed
 * 4. Initialize variables
 * 5. Get user input in userInput String and use replaceAll method to remove spaces and toLowerCase to make all characters lower case.
 * 6. If the userInput is 1 or 0 characters, it is automatically a palindrome.
 * 7. Create for loop to push each character at i iterations of the loop on to the stack and to not include the middle character if the string is an odd length.
 * 8. Update size to shorten by 1 if the string was in fact odd length.
 * 9. Create another for loop to pop from stack1 and push that character to stack2 until they are 50/50 in size.
 * 10. Create another for loop to pop each stack into its own respective String.
 * 11. If the two Strings for the stack are the same, then it is a palindrome. Else it is not a palindrome.
 * 
 * */

import java.util.Scanner;
public class Driver 
{
	public static void main(String[] args)
	{
		ArrayStack<Character> stack1 =  new ArrayStack<Character>();
		ArrayStack<Character> stack2 =  new ArrayStack<Character>();
		Scanner keyboard;
		String userInput, stackString1, stackString2;
		int size;
		
		keyboard = new Scanner(System.in);
		stackString1 = "";
		stackString2 = "";
		System.out.print("Please enter a word: ");
		userInput = keyboard.nextLine().replaceAll(" ", "").toLowerCase();
		keyboard.close();
		size = userInput.length();
		
		if(size < 2)
		{
			System.out.println("It's a palindrome!");
			System.exit(0);
		}
		
		for(int i = 0; i < size; i++)
		{
			if(!(size % 2 == 1 && size / 2 == i))
			{
				stack1.push(userInput.charAt(i));
				System.out.println(stack1.peek());
			}
		}
		size = size - (size % 2);
		//System.out.println(size);
		
		for(int i = 0; i < size / 2; i++)
		{
			stack2.push(stack1.pop());
		}
		
		for(int i = 0; i < size / 2; i++)
		{
			stackString1 = stackString1 + stack1.pop();
			stackString2 = stackString2 + stack2.pop();
		}
		
		if(stackString1.equals(stackString2))
		{
			System.out.println("It's a palindrome!");
		}
		else
		{
			System.out.println("It's not a palindrome!");
		}
	}
}

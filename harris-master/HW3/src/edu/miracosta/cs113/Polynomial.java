/**
 * @author Kyle Harris
 * @version 0.5
 * 
 * Algorithm:
 * 1. Declare and initialize two objects of SingleLinkedList.
 * 2. Declare and initialize others where necesarry.
 * 3. Create while loop and keep taking userInput until user puts in "-1."
 * 4. For each iteration of the loop, add each piece of user input to their respective linked list,
 * incrementing the Node position each time.
 * 5. Output linked list in a for loop.
 * */
 

package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial<E>
{
public static void main(String[] args)
	{
		SingleLinkedList coefList = new SingleLinkedList();
		SingleLinkedList exponentList = new SingleLinkedList();
		
		Scanner keyboard;
		String userInput;
		int coefInput, exponentInput, position;
		LinkedList coef = new LinkedList();
		
		keyboard = new Scanner(System.in);
		exponentInput = 0;
		position = 0;
		coefInput = 0;
		
		while(coefInput != -1)
		{
			System.out.print("Please enter the coeficient of a value of your polynomial(-1 to exit): ");
			userInput = keyboard.nextLine();
			coefInput = Integer.parseInt(userInput);
			if(coefInput != -1)
			{
				System.out.print("To the power of (enter your exponent): ");
				userInput = keyboard.nextLine();
				exponentInput = Integer.parseInt(userInput);
				
				
				coefList.add(position, coefInput);
				exponentList.add(position, exponentInput);
				position++;
			}	
		}
		keyboard.close();
		
		System.out.print(coefList.get(0) + "x^" + exponentList.get(0));
		for(int i = 1; i < coefList.size(); i++)
		{
			System.out.print(" + " + coefList.get(i) + "x^" + exponentList.get(i));
		}
	}
}
package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create two arrays, one with number values and one that has numbers to guess and see if it is in objArray. Guess intentionally has some right answers.
 * 2. Print out objArray with loop to show what's inside
 * 3. Use ObjectLocator and guess array to search for values inside objArray
 * */

public class Tester
{
	public static void main(String[] args)
	{
		Object[] objArray = {50, 23, 55, 60, 47};
		Object[] guess = {45, 55, 87, 32, 23};
		
		System.out.println("Our object array consists of: ");
		for(int i = 0; i < objArray.length; i++)
		{
			System.out.println((i + 1) + ". " + objArray[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i < objArray.length; i++)
		{
			System.out.println("Searching for: " + guess[i]);
			ObjectLocator.findIndex(objArray, guess[i]);
			System.out.println();
		}
	}
}

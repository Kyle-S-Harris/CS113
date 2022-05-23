package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm: Test multiple values up to 4 digits in array, sort them with radix sort, then output.
 * 
 * */
public class Tester 
{
	public static void main(String[] args)
	{
		RadixSort sorter = new RadixSort();
		int[] inputArray = {858, 55, 6, 3445, 5656, 7367, 1204, 2346, 2756, 2844, 2047, 1034, 9806, 8964, 1023, 600, 234, 454};
		sorter.sort(inputArray);
		System.out.println("Printing radix sorted array:");
		for(int i = 0; i < inputArray.length; i++)
		{
			System.out.println(inputArray[i]);
		}
	}
}

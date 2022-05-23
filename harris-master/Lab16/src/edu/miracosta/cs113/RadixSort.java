package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */
public class RadixSort 
{	
	/**
	 * @param inputArray The array to be sorted with in radix sort form
	 * */
	public void sort(int[] inputArray)
	{
		int[] bucket;
		int[] sortedArray = new int[inputArray.length];
		int digitsPlace = 1;
		
		while(getMax(inputArray) / digitsPlace > 0)
		{
			bucket = new int[10];
			
			//Stores the number of keys for each value of 0 - 9
			for(int i = 0; i < inputArray.length; i++)
			{
				bucket[(inputArray[i] / digitsPlace) % 10]++;
			}
		
			//Changes bucket to store position in which the relative digit belongs in the final sorted array
			for(int i = 1; i < bucket.length; i++)
			{
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			
			//Builds the sorted array by going through inputArray values in reverse and assigns value to proper place in the sorted array 
			for(int i = (inputArray.length - 1); i >= 0; i--)
			{
				sortedArray[bucket[(inputArray[i] / digitsPlace) % 10] - 1] = inputArray[i];
				bucket[(inputArray[i] / digitsPlace) % 10]--;
			}
			
			//Transfers values from sorted array back into the original input array
			for(int i = 0; i < inputArray.length; i++)
			{
				inputArray[i] = sortedArray[i];
			}
			
			//Changes digits place to tens place, hundreds place, thousands place, etc.
			digitsPlace = digitsPlace * 10;
		}
	}
	
	/**
	 * @param array The array to find the max digit
	 * @return maxDigit The maxDigit of the array
	 * */
	private int getMax(int[] array)
	{
		 int maxDigit = array[0];
		 
		 for(int i = 0; i < array.length - 1; i++)
		 {
			 if(array[i] > maxDigit)
			 {
				 maxDigit = array[i];
			 }
		 }
		 return maxDigit;
	}
}

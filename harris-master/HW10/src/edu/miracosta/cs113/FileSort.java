package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */

import java.util.List;
import java.util.ArrayList;

public class FileSort 
{
	/**
	 * @param table The array type of values to be sorted
	 * */
	public static <T extends Comparable<T>> void sort(T[] table)
	{
		if(table.length > 1)
		{
			int halfSize = table.length / 2;
			T[] leftTable = (T[]) new Comparable[halfSize];
			T[] rightTable = (T[]) new Comparable[table.length - halfSize];
			System.arraycopy(table, 0, leftTable, 0, halfSize);
			System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
			
			sort(leftTable);
			sort(rightTable);
			
			merge(table, leftTable, rightTable);
		}
	}
	
	/**
	 * @param table The List type of values to be sorted
	 * */
	public static <T extends Comparable<T>> void sort(List<T> table)
	{
		if(table.size() > 1)
		{
			int halfSize = table.size() / 2;
			List<T> leftTable = new ArrayList<T>(table.subList(0, halfSize));
			List<T> rightTable = new ArrayList<T>(table.subList(halfSize, table.size()));
			
			sort(leftTable);
			sort(rightTable);
			
			merge(table, leftTable, rightTable);
		}
	}
	
	/**
	 * @param outputSequence The array type that leftSequence and rightSequence will be merged to
	 * @param leftSequence The array type of values that are to be merged with rightSequence into outputSequence
	 * @param rightSequence The array type of values that are to be merged with leftSequence into outputSequence
	 * */
	private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < leftSequence.length && j < rightSequence.length)
		{
			if(leftSequence[i].compareTo(rightSequence[j]) < 0)
			{
				outputSequence[k++] = leftSequence[i++];
			}
			else
			{
				outputSequence[k++] = rightSequence[j++];
			}
		}
		
		while(i < leftSequence.length)
		{
			outputSequence[k++] = leftSequence[i++];
		}
		
		while(j < rightSequence.length)
		{
			outputSequence[k++] = rightSequence[j++];
		}
	}
	
	/**
	 * @param outputSequence The List type that leftSequence and rightSequence will be merged to
	 * @param leftSequence The List type of values that are to be merged with rightSequence into outputSequence
	 * @param rightSequence The List type of values that are to be merged with leftSequence into outputSequence
	 * */
	private static <T extends Comparable<T>> void merge(List<T> outputSequence, List<T> leftSequence, List<T> rightSequence)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < leftSequence.size() && j < rightSequence.size())
		{
			if(leftSequence.get(i).compareTo(rightSequence.get(j)) < 0)
			{
				outputSequence.set(k++, leftSequence.get(i++));
			}
			else
			{
				outputSequence.set(k++, rightSequence.get(j++));
			}
		}
		
		while(i < leftSequence.size())
		{
			outputSequence.set(k++, leftSequence.get(i++));
		}
		
		while(j < rightSequence.size())
		{
			outputSequence.set(k++, rightSequence.get(j++));
		}
	}

}

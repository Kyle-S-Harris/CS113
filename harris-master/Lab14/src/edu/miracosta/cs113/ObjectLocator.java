package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * */

public class ObjectLocator
{
	/**
	 * @param table The table in which an object is located
	 * @param obj The object in which is being searched for in the table
	 * @return -1 If the table at the specified index is null or all functions fail to return anything
	 * @return index If the object is found
	 * */
	public static int findIndex(Object[] table, Object obj)
	{
		int index;
		index = obj.hashCode() % table.length;
		
		if(table[index] == null)
		{
			System.out.println("The object is not here!");
			return -1;
		}
		else if(table[index] == obj)
		{
			System.out.println("The object is here!");
			return index;
		}
		else
		{
			for(index = 0; index < table.length; index++)
			{
				if(table[index] == null)
				{
					System.out.println("The object is not here!");
					return -1;
				}
				else if(table[index] == obj)
				{
					System.out.println("The object is here!");
					return index;
				}
			}
		}
		System.out.println("The object is not here!");
		return -1;
	}
}

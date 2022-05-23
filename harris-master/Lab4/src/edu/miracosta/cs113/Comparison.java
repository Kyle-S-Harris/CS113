package edu.miracosta.cs113;

/**
 * @author Kyle Harris
 * @version 1.0 
 * */

public class Comparison
{
	public static void main(String[] args)
	{
		int y1, y2, n;
		
		n = 10;
		
		while(n < 100)
		{
			y1 = 100 * n + 10;
			y2 = 5 * n * n + 2;
			System.out.println("y1: " + y1);
			System.out.println("y2: " + y2);
			
			n++;
		}
	}
}


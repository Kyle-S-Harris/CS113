package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create class MultipleFinder with main method
 * 2. Declare variables for counter, fizz, and buzz
 * 3. Initialize: counter to 1, fizz to 3, buzz to 5
 * 4. Create while loop with an ending condition of greater than 100.
 * 5. If counter divided by fizz has a remainder of 0 and counter divided by buzz has a remainder of 0, output "Fizzbuzz".
 * 6. Else if counter divided by fizz has a remainder 0, output "Fizz".
 * 7. Else if counter divided by buzz has a remainder of 0, output "Buzz".
 * 8. Else, output counter
 * 9. Increment counter 
 * */
public class MultipleFinder
{
	public static void main(String[] args)
	{
		int counter, fizz, buzz;
		
		counter = 1;
		fizz = 3;
		buzz = 5;
		
		
		while(counter <= 100)
		{
			if(((counter % fizz) == 0) && ((counter % buzz) == 0))
			{
				System.out.println("Fizzbuzz");
			}
			
			else if((counter % fizz) == 0)
			{
				System.out.println("Fizz");
			}
			
			else if((counter % buzz) == 0)
			{
				System.out.println("Buzz");
			}
			
			else
			{
				System.out.println(counter);
			}
			counter++;
		}
		
	}
}

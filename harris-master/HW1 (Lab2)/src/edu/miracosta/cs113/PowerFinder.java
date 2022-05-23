package edu.miracosta.cs113;
/**PowerFinder.java: Determines whether a number the user enters is a power of 2 or not.
 * 
 * @author Kyle Harris
 * @version 1.0.1
 * 
 * Algorithm:
 * 1. Declare variables to keep track of userInput, the number from userInput (parse it),
 * a boolean variable to break out of loops when needed.
 * 2. Make for loop that repeats core functions of the program 3 times (so 3 different values can be plugged in)
 * 3. Get user input (any real number)
 * 4. If the number is less than or equal to 1, output that it is not a power of 2. Exit program.
 * 5. Create while loop with a condition of end equaling false
 * 6. If the number the user entered divided by 2 has a remainder and is not equal to 1, it is not a power of 2. Set end equal to true.
 * 7. Else if the number is equal to 1 (after step 4 that is), it is a power of 2. Set end equal to true
 * 8. Else, set num = num / 2. End will stay false and the loop will repeat in this case.
 * 
 * */
import java.util.Scanner;

public class PowerFinder
{
	public static void main(String[] args)
	{
		int num;
		String userInput;
		boolean end;
		Scanner keyboard;
		
		keyboard = new Scanner(System.in);
		for(int i = 0; i < 3; i++)
		{
			
			System.out.print("\nEnter a number to see if it is a power of 2: ");
			userInput = keyboard.nextLine();
			num = Integer.parseInt(userInput);
			
			end = false;
			
			if(num <= 1)
			{
				System.out.println("Not a power of 2");
				end = true;
			}
			
			while(end == false)
			{
				if(num % 2 != 0 && num != 1)
				{
					System.out.println("Not a power of 2.");
					end = true;
				}
				
				else if(num == 1)
				{
					System.out.println("Is a power of 2.");
					end = true;
				}
				
				else
				{
					num = num / 2;
				}
			}
		}
		keyboard.close();
		
	}
}
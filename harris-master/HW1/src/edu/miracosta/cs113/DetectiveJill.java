package edu.miracosta.cs113;

/**DetectiveJill.java: This class is to determine what the correct theory is to solve the murder mystery. 
 * 
 * @author Kyle Harris
 * @version 1.0.1
 * 
 * Algorithm:
 * 1. Declare variables to keep track of the suspect, location, weapon. As well as
 * variables to hold random TheoryItems for choice number 3. Include other necesarry variables.
 * 2. Initialize all variables where necesarry.
 * 3. Get user input (1, 2, or 3)
 * 4. Determine what option the user chose and tie that to the appropriate answerSet (if-elses).
 * 5. Use do-while loops to go through each theory item one at a time until the correct item is found.
 * Increment timesAsked for each iteration of the loop.
 * 6. Once all correct theory items are found, determine if the answer was found in less than 20 tries.
 * If found in less than 20, it is a success; if not, it is a failure.
 */

import java.util.Random;
import java.util.Scanner;


public class DetectiveJill 
{
	public static void main(String[] args) 
	{
		//DECLARATIONS
		Scanner keyboard;
		int answerSet, suspect, location, weapon, randomSuspect, randomLocation, 
		randomWeapon, timesAsked;
		boolean correctSuspect, correctLocation, correctWeapon; 
		String choice;
		Theory theoryCombo;
		Random randomNum;
		
		//INITIALIZATIONS
		suspect = 1;
		location = 1;
		weapon = 1;
		
		
		keyboard = new Scanner(System.in);
		
		timesAsked = 0;
		
		correctSuspect = false;
		correctLocation = false;
		correctWeapon = false;
		
		randomNum = new Random();
		
		//USER INPUT
		System.out.println("Pick a theory to determine who the murder suspect is.");
		System.out.print("Which theory do you want to try (1 = (1,1,1), 2 = (6,10,6), 3 = random): "); 
		choice = keyboard.nextLine();
		answerSet = Integer.parseInt(choice);
		keyboard.close();
		
		//IF-ELSEIF-ELSE TO DETERMINE WHICH ANSWER-SET THE USER WANTS
		if(answerSet == 1)
		{
			theoryCombo = new Theory (1, 1, 1);
		}
		
		else if(answerSet == 2)
		{
			theoryCombo = new Theory (6, 10, 6);
		}
		
		else
		{
			randomSuspect = randomNum.nextInt(6) + 1;
			randomLocation = randomNum.nextInt(10) + 1;
			randomWeapon = randomNum.nextInt(6) + 1;
			theoryCombo = new Theory(randomSuspect, randomLocation, randomWeapon);
		}
		
		//DO-WHILE'S TO LOOP THROUGH EACH POSSIBILITY FOR EACH THEORY ITEM UNTIL IT IS RIGHT
		do
		{
			timesAsked++;
			if(suspect == theoryCombo.getPerson())
			{
				correctSuspect = true;
			}
			
			else
			{
				suspect++;
			}
			
		}while(correctSuspect != true);
		
		do
		{
			timesAsked++;
			if(location == theoryCombo.getLocation())
			{
				correctLocation = true;
			}
			
			else
			{
				location++;
			}
			
		}while(correctLocation != true);
		
		do
		{
			timesAsked++;
			if(weapon == theoryCombo.getWeapon())
			{
				correctWeapon = true;
			}
			
			else
			{
				weapon++;
			}
			
		}while(correctWeapon != true);
		
		System.out.println("Number of checks: " + timesAsked);
		
		if(timesAsked < 20)
		{
			System.out.println("Congrats! You are a great detective!");
		}
		
		else
		{
			System.out.println("How did you even graduate the academy?!");
		}
		
	}
}

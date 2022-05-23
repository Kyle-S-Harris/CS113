/**
 * @author Kyle Harris
 * @version 0.6
 * 
 * Algorithm 
 * 1. Create MorseDriver class, implementing Serializable
 * 2. Write morse strings to file with ObjectOutputStream
 * 3. Read back morse string with ObjectInputStream
 * 4. Populate the tree with morse information
 * 5. Take user input of a letter and search for that letter's morse code in the tree
 * 6. Output the translation when user is done
 * */

package edu.miracosta.cs113;

import java.io.*;

//import java.io.FileInputStream;

public class MorseDriver implements Serializable
{
	public static void main(String[] args)
	{
		BinaryTree<String> morseTree = new BinaryTree<String>();
		
		/*try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("morsecode.txt"));
			out.writeObject("e*\n" + 
					"t -\n" + 
					"i **\n" + 
					"a *-\n" + 
					"n -*\n" + 
					"m --\n" + 
					"s ***\n" + 
					"u **-\n" + 
					"r *-*\n" + 
					"w *--\n" + 
					"d -**\n" + 
					"k -*-\n" + 
					"g --*\n" + 
					"o ---\n" + 
					"h ****\n" + 
					"v ***-\n" + 
					"f **-*\n" + 
					"l *-**\n" + 
					"p *--*\n" + 
					"j *---\n" + 
					"b -***\n" + 
					"x -**-\n" + 
					"c -*-*\n" + 
					"y -*--\n" + 
					"z --**\n" + 
					"q --*-");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}*/
		
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("morsecode.txt"));
			morseTree = (BinaryTree<String>)in.readObject();
		}
		catch(ClassCastException e)
		{
			
		}
		catch(StreamCorruptedException e)
		{
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Sorry, this morse code translator is out of order.");
	}
}

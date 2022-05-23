package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 0.9
 * 
 * Algorithm
 * 1. Declare necessary objects and variables
 * 2. Write several random values to inputfile.txt
 * 3. Add runSize number of elements to outputFileOneArray
 * 4. Sort outputFileOneArray
 * 5. Add runSize number of elements to outputFileTwoArray
 * 6. Sort outputFileOneArray
 * 7. Append outputFileOneArray to outputfileone.txt
 * 8. Append outputFileTwoArray to outputfiletwo.txt
 * 9. Repeat until inputfile.txt has been traversed
 * 10. Read output file text files back into new array lists and merge them into the original file (inputfile.txt)
 * 11. Multiply runSize by two
 * 12. Repeat to step 3 until runSize is greater than fileSize
 * */


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.List;
import java.util.ArrayList;

public class Driver<T extends Comparable<T>>
{
	
	public static void main(String[] args)
	{
		FileSort sorter = new FileSort();
	
		List<Integer> outputFileOneArray = new ArrayList<Integer>();
		List<Integer> outputFileTwoArray = new ArrayList<Integer>();
		List<Integer> inputFileArray1 = new ArrayList<Integer>();
		List<Integer> inputFileArray2 = new ArrayList<Integer>();
		List<Integer> finalArray1 = new ArrayList<Integer>();
		
		boolean endOfInputFile = false, endOfOutputFile = false;
		
		int index = 0, fileSize = 160, runSize = 10, currentIteration = 0, numElements = 100;
		
		
		try
		{
			
			ObjectOutputStream inputFileOut = new ObjectOutputStream(new FileOutputStream("inputfile.txt"));
			ObjectOutputStream outputFileOneOut = new ObjectOutputStream(new FileOutputStream("outputfileone.txt"));
			ObjectOutputStream outputFileTwoOut = new ObjectOutputStream(new FileOutputStream("outputfiletwo.txt"));
			
			
			while(index < fileSize)
			{
				inputFileOut.writeObject((Integer)(int)(Math.random() * 1000 + 1));
				index++;
			}
			inputFileOut.close();
			
			//IMPORTANT NOTE:
			//Do-while was intended to keep running the file sorting operations until runSize was greater than fileSize, but ultimately did not work right
			//do
			//{
				outputFileOneArray.clear();
				outputFileTwoArray.clear();
				inputFileArray1.clear(); 
				inputFileArray2.clear();
				endOfInputFile = false;
				endOfOutputFile = false;
				
				
				
				//Reads object from input file
				ObjectInputStream inputFileIn = new ObjectInputStream(new FileInputStream("inputfile.txt"));
				
				//Writes to output files
				outputFileOneOut = new AppendableObjectOutputStream(new FileOutputStream("outputfileone.txt", true));
				outputFileTwoOut = new AppendableObjectOutputStream(new FileOutputStream("outputfiletwo.txt", true));
				
				//Writing input file values to outputfile one array
				while(endOfInputFile == false)
				{
					
					try 
					{
						for(int i = 0; i < runSize; i++)
						{
							outputFileOneArray.add((Integer) inputFileIn.readObject());
						}
					}
					catch(EOFException e)
					{
						endOfInputFile = true;
					}
					sorter.sort(outputFileOneArray);
					
					
					//Writing input file values to outputfile two array
					try
					{
						for(int i = 0; i < runSize; i++)
						{
							outputFileTwoArray.add((Integer) inputFileIn.readObject());
						}
					}
					catch(EOFException e)
					{
						endOfInputFile = true;
					}
					
					sorter.sort(outputFileTwoArray);
					
					
					//Outputting arrays to output files
					for(int i = 0; i < runSize; i++)
					{
						outputFileOneOut.writeObject(outputFileOneArray.get(i));
					}
					
					for(int i = 0; i < runSize; i++)
					{
						outputFileTwoOut.writeObject(outputFileTwoArray.get(i));
					}
					
				}
				inputFileIn.close();
				outputFileOneOut.close();
				outputFileTwoOut.close();
				
				
				
				ObjectOutputStream inputFileOut2 = new ObjectOutputStream(new FileOutputStream("inputfile.txt"));
				ObjectInputStream outputFileOneIn = new ObjectInputStream(new FileInputStream("outputfileone.txt"));
				ObjectInputStream outputFileTwoIn = new ObjectInputStream(new FileInputStream("outputfiletwo.txt"));
				//Reading output files values back to input arrays
				while(endOfOutputFile == false)
				{
					
					try
					{
						for(int i = 0; i < runSize; i++)
						{
							inputFileArray1.add((Integer) outputFileOneIn.readObject());
						}
					}
					catch(EOFException e)
					{
						endOfOutputFile = true;
					}
					
					try
					{
						for(int i = 0; i < runSize; i++)
						{
							inputFileArray2.add((Integer) outputFileTwoIn.readObject());
						}
					}
					catch(EOFException e)
					{
						endOfOutputFile = true;
					}
					
					
					//MERGING TEMP FILES FROM INPUT FILE ARRAYS BACK TO INPUTFILE
					int i = 0;
					int j = 0;
					
					while(i < inputFileArray1.size() || j < inputFileArray2.size())
					{
						if(i < inputFileArray1.size() && j < inputFileArray2.size())
						{
							if(inputFileArray1.get(i).compareTo(inputFileArray2.get(j)) > 0)
							{
								inputFileOut2.writeObject(inputFileArray2.get(j));
								j++;
							}
							else
							{
								inputFileOut2.writeObject(inputFileArray1.get(i));
								i++;
							}
						}
						else if(i < inputFileArray1.size())
						{
							inputFileOut2.writeObject(inputFileArray1.get(i));
							i++;
						}
						else
						{
							inputFileOut2.writeObject(inputFileArray2.get(j));
							j++;
						}
					}
				}
				inputFileOut2.close();
				outputFileOneIn.close();
				outputFileTwoIn.close();
				
				
								
				/*System.out.println("Filesize: " + fileSize);
				System.out.println("Runsize: " + runSize);
				runSize = runSize * 2;
				System.out.println("Runsize: " + runSize);*/
				
			
			//}while(runSize < fileSize);
			
			//Console Output Section
			ObjectInputStream inputFileIn2 = new ObjectInputStream(new FileInputStream("inputfile.txt"));
			
			//This outputs the inputfile's somewhat sorted values, which is at least accomplishes the first run of the file sort
			try 
			{
				//Notice this output's pattern
				System.out.println("What it actually looks like (somewhat sorted, but not complete): ");
				for(int index2 = 0; index2 < fileSize; index2++)
				{
					System.out.println((Integer)inputFileIn2.readObject());
				}
			inputFileIn2.close();
			}
			catch(EOFException e)
			{
			}
			
			//This section is just trying to output the sorted values, which weren't done the way the assignment asked, but it's something.
			ObjectInputStream inputFileIn3 = new ObjectInputStream(new FileInputStream("inputfile.txt"));
			
			for(int i = 0; i < fileSize; i++)
			{
				finalArray1.add((Integer) inputFileIn3.readObject());
				
			}
			
			sorter.sort(finalArray1);
			
			System.out.println("\n\nWhat it should look like (generated by getting somewhat sorted values from inputfile.txt, putting them in arrayList and sorting it all at once): ");
			for(int i = 0; i < fileSize; i++)
			{
				System.out.println(finalArray1.get(i));
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

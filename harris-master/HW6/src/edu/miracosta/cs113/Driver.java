package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 0.2
 * 
 * Algorithm:
 * 1. Declare necessary objects and variables
 * 2. Set min and max pages
 * 3. Add all print jobs to array
 * 4. Add jobs from jobArray to their respective priority queue based off of num pages
 * 5. Print out from each printer starting with high priority
 * */
public class Driver 
{
	public static void main(String[] args)
	{
		int[] jobPages = {4, 15, 23, 44, 30};
		PrintJob[] jobArray = new PrintJob[5];
		
		Printer lowPriority = new Printer();
		Printer medPriority = new Printer();
		Printer highPriority = new Printer();
		
		int minutes, jobsCompleted, totalNumJobs;
		
		lowPriority.setMinPages(1);
		lowPriority.setMaxPages(10);
		
		medPriority.setMinPages(11);
		medPriority.setMaxPages(20);
		
		highPriority.setMinPages(21);
		highPriority.setMaxPages(50);
		
		minutes = 0;
		jobsCompleted = 0;
		totalNumJobs = 5;
		
		for(int i = 0; i < totalNumJobs; i++)
		{
			PrintJob job = new PrintJob();
			job.setNumPages(jobPages[i]);
			job.setPagesLeft(jobPages[i]);
			jobArray[i] = job;
			//System.out.println(jobArray[i].getNumPages());
	
		}
		
		for(int i = 0; i < totalNumJobs; i++)
		{
			if(jobArray[i].getNumPages() <= 10)
			{
				highPriority.addJob(jobArray[i]);
			
			}
			else if(jobArray[i].getNumPages() > 10 && jobArray[i].getNumPages() <= 20)
			{
				medPriority.addJob(jobArray[i]);
			
			}
			else
			{
				lowPriority.addJob(jobArray[i]);
			
			}
		}
		
		for(int i = 0; i < totalNumJobs; i++)
		{
			if(jobArray[i].getNumPages() <= 10)
			{
				highPriority.setJob();
				minutes++;
			}
			while(highPriority.finishedProcess() != true)
			{
				highPriority.processPage();
				if(jobArray[i].getPagesLeft() % 10 == 0)
				{
					minutes++;
				}
			}
		}
		
		for(int i = 0; i < totalNumJobs; i++)
		{
			if(jobArray[i].getNumPages() > 10 && jobArray[i].getNumPages() <= 20)
			{
				medPriority.setJob();
				minutes++;
			}
			while(medPriority.finishedProcess() != true)
			{
				medPriority.processPage();
				
				if(jobArray[i].getPagesLeft() % 10 == 0)
				{
					minutes++;
				}
			}
		}
		
		for(int i = 0; i < totalNumJobs; i++)
		{
			if(jobArray[i].getNumPages() > 20)
			{
				lowPriority.setJob();
				minutes++;
			}
			while(lowPriority.finishedProcess() != true)
			{
				lowPriority.processPage();
				
				if(jobArray[i].getPagesLeft() % 10 == 0)
				{
					minutes++;
				}
			}
		}
		
		System.out.println("Done");
	}
}

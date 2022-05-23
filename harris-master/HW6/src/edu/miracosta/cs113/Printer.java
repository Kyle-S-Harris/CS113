package edu.miracosta.cs113;

/**
 * @author Kyle Harris
 * @version 0.2
 * */

import java.util.LinkedList;
import java.util.Queue;

public class Printer 
{
	private Queue<PrintJob> pendingJobs = new LinkedList<PrintJob>(); //pendingJobs
	private int minPages;
	private int maxPages;
	private PrintJob currentJob; //currentJob
	
	//canHandleJob(PrintJob) returns boolean
	
	public Printer()
	{
		this.minPages = 1;
		this.maxPages = 100;
		this.currentJob = null;
	}
	
	public Printer(int minPages, int maxPages, PrintJob job)
	{
		this.setMinPages(minPages);
		this.setMaxPages(maxPages);
				
	}
	
	public void setMinPages(int minPages)
	{
		this.minPages = minPages;
	}
	
	public void setMaxPages(int maxPages)
	{
		this.maxPages = maxPages;
	}
	
	public void setJob()
	{
		this.currentJob = pendingJobs.poll();
	}
	
	public int getMinPages()
	{
		return this.minPages;
	}
	
	public int getMaxPages()
	{
		return this.maxPages;
	}
	
	public PrintJob getNextJob()
	{
		return this.pendingJobs.peek();
	}
	
	public int getPagesLeft()
	{
		return currentJob.getPagesLeft();
	}
	
	public PrintJob ticker() 
	{
		if(pendingJobs.peek() == null)
		{
			return null;
		}
		else
		{
			PrintJob newJob = pendingJobs.peek();
			newJob.setPagesLeft(newJob.getPagesLeft() - 10);
			if(newJob.getPagesLeft() < 1)
			{
				return pendingJobs.poll();
			}
		}
		return null;
	}
	
	public boolean addJob(PrintJob newJob)
	{
		if(this.minPages < newJob.getNumPages() || this.maxPages > newJob.getNumPages())
		{
			return false;
		}
		else
		{
			pendingJobs.offer(newJob);
			return true;
		}
	}
	
	public boolean finishedProcess()
	{
		if(this.currentJob == null || this.currentJob.getPagesLeft() == 0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void processPage()
	{
		this.currentJob.decrementPagesLeft();
	}
	
	public Queue<PrintJob> getQueue()
	{
		return this.pendingJobs;
	}
	//boolean currentCompleted(), boolean isReady(for next job), void processPage()
}

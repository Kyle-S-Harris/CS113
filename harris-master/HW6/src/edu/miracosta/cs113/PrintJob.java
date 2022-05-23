package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 0.2
 * */
public class PrintJob 
{
	private int numPages;
	private int pagesLeft;
	
	public PrintJob()
	{
		this.numPages = 1;
		this.pagesLeft = 1;
	}
	
	public PrintJob(int numPages, int pagesLeft)
	{
		this.setNumPages(numPages);
		this.setPagesLeft(pagesLeft);
	}
	
	public PrintJob(PrintJob object) 
	{
		this.setNumPages(object.numPages);
		this.setPagesLeft(object.pagesLeft);
	}
	
	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}
	
	public void setPagesLeft(int pagesLeft)
	{
		this.pagesLeft = pagesLeft;
	}
	
	public int getNumPages() 
	{
		return this.numPages;
	}
	
	public int getPagesLeft() 
	{
		return this.pagesLeft;
	}
	
	public void decrementPagesLeft()
	{
		this.pagesLeft--;
	}
}

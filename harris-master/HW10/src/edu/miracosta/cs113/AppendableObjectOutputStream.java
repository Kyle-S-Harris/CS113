package edu.miracosta.cs113;
/**
 * @author Kyle Harris (Based on class made by Professor June Porto)
 * @version 1.0
 * */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream
{
	public AppendableObjectOutputStream(OutputStream out) throws IOException 
	{
		super(out);
	}
	
	protected void writeStreamHeader() throws IOException
	{
		reset();
	}
}

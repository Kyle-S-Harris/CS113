package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create two objects of MinHeap and MaxHeap (one of each). Use full constructor for MaxHeap and pass a Comparator reverseOrder
 * 2. Fill minHeap PriorityQueue with multiple integers using offer() method
 * 3. Fill maxHeap PriorityQueue with multiple integers using offer() method
 * 4. Output the values of minHeap PriorityQueue by using the poll() method
 * 5. Output the values of maxHeap PriorityQueue by using the poll() method
 * 6. Test minHeap compare method with if statements, using both true and false data
 * 7. Test miaxHeap compare method with if statements, using both true and false data
 * 
 * */
import java.util.Comparator;

public class Tester 
{
	public static void main(String[] args)
	{
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(Comparator.reverseOrder());
		
		minHeap.getQueue().offer(1);
		minHeap.getQueue().offer(55);
		minHeap.getQueue().offer(11);
		minHeap.getQueue().offer(30);
		minHeap.getQueue().offer(15);
		minHeap.getQueue().offer(25);
		
		maxHeap.getQueue().offer(1);
		maxHeap.getQueue().offer(53);
		maxHeap.getQueue().offer(14);
		maxHeap.getQueue().offer(90);
		maxHeap.getQueue().offer(67);
		maxHeap.getQueue().offer(29);
		
		System.out.println("Testing the MinHeap: ");
		System.out.println(minHeap.getQueue().poll());
		System.out.println(minHeap.getQueue().poll());
		System.out.println(minHeap.getQueue().poll());
		System.out.println(minHeap.getQueue().poll());
		System.out.println(minHeap.getQueue().poll());
		System.out.println(minHeap.getQueue().poll());
		
		System.out.println("\nTesting the MaxHeap: ");
		System.out.println(maxHeap.getQueue().poll());
		System.out.println(maxHeap.getQueue().poll());
		System.out.println(maxHeap.getQueue().poll());
		System.out.println(maxHeap.getQueue().poll());
		System.out.println(maxHeap.getQueue().poll());
		System.out.println(maxHeap.getQueue().poll());
		
		
		System.out.println("\nTesting min heap compare method in if statement with 55 as the parent and 10 as the min value: ");
		//If this if statement runs, the compare method works properly for MinHeap
		if(minHeap.compare(55, 10) > 0)
		{
			System.out.println(10);
			System.out.println(55);
		}
		
		//If this if statement DOESN'T run, then the compare method still works properly
		if(minHeap.compare(5, 25) > 0)
		{
			System.out.println(5);
			System.out.println(25);
		}
		
		System.out.println("\nTesting max heap compare method in if statement with 10 as the parent and 55 as the max value: ");
		//If this if statement runs, the compare method works properly for MaxHeap
		if(maxHeap.compare(10, 55) == 0)
		{
			System.out.println(55);
			System.out.println(10);
		}
		
		//If this if statement DOESN'T run, then the compare method still works properly
		if(maxHeap.compare(25, 5) == 0)
		{
			System.out.println(25);
			System.out.println(5);
		}
	}
}

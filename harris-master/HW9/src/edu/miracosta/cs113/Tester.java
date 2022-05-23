package edu.miracosta.cs113;
/**
 * @author Kyle Harris
 * @version 1.0
 * 
 * Algorithm:
 * 1. Create HashTableChain, Iterator (using SetIterator), and Set (using EntrySet) objects.
 * 2. Create two arrays of equal lengths, one with values for the hash table and one for the keys of the corresponding hash table values.
 * 3. Check if hash table is empty and what the size is
 * 4. Set the hash table by testing the put method with both arrays
 * 5. Get the hash table values by testing the get method
 * 6. Print the HashTableChain toString
 * 7. Test SetIterator in while loop by outputting it which results in the toString being called, check for empty and size
 * 8. Test the rehash method and reinitialize the SetIterator and output it which should produce the toString that results after rehash, check for empty and size
 * 9. Test remove method on all keys of hash table with while loop and test SetIterator again, if SetIterator doesn't run, then the hash table is empty.
 * 10. Check for size and isEmpty() one last time
 * 
 * */
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tester 
{
	public static void main(String[] args)
	{
		HashTableChain<Integer, Integer> hashTableChain = new HashTableChain<Integer, Integer>();
		Iterator<Map.Entry<Integer, Integer>> iterator = hashTableChain.entrySet().iterator();
		Set<Map.Entry<Integer, Integer>> entrySet = hashTableChain.entrySet();
		int[] numArray = {1, 20, 5, 70, 50, 30, 26, 27};
		int[] keyArray = {2, 85, 40, 38, 48, 76, 54, 25};	
		
		
		System.out.println("Is HashTable empty: " + hashTableChain.isEmpty());
		System.out.println("What is the size from HashTableChain: " + hashTableChain.size());
		System.out.println("What is the size from EntrySet inner class: " + entrySet.size());
		
		
		System.out.println("Setting hash table");
		for(int i = 0; i < keyArray.length; i++)
		{
			hashTableChain.put(keyArray[i], numArray[i]);
		}
		System.out.println("Done");
		
		
		System.out.println("\nGetting hash table values with keys in order of keyArray: ");
		for(int i = 0; i < keyArray.length; i++)
		{
			System.out.println(hashTableChain.get(keyArray[i]));
		}
		
		
		System.out.println("\nTesting toString() for HashTableChain: ");
		System.out.println(hashTableChain.toString());
		
		
		
		System.out.println("\nTesting SetIterator and outputting toString().");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("\nIs HashTable empty: " + hashTableChain.isEmpty());
		System.out.println("What is the size from HashTableChain: " + hashTableChain.size());
		System.out.println("What is the size from EntrySet inner class: " + entrySet.size());
		
		
		System.out.println("\nTesting rehash method.");
		hashTableChain.rehash();
		
		
		System.out.println("Reinitializing SetIterator.");
		System.out.println("If the toString() with the key and value reappears correctly following this message, then rehash works properly.");
		iterator = hashTableChain.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("\nIs HashTable empty: " + hashTableChain.isEmpty());
		System.out.println("What is the size from HashTableChain: " + hashTableChain.size());
		System.out.println("What is the size from EntrySet inner class: " + entrySet.size());
		
		
		
		System.out.println("\nTesting remove method on all keys.");
		for(int i = 0; i < keyArray.length; i++)
		{
			hashTableChain.remove(keyArray[i]);
		}
		
		
		System.out.println("If SetIterator doesn't run after removing then it is working properly.");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("\nIs HashTable empty: " + hashTableChain.isEmpty());
		System.out.println("What is the size from HashTableChain: " + hashTableChain.size());
		System.out.println("What is the size from EntrySet inner class: " + entrySet.size());
	}
}

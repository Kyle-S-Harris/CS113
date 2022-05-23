package edu.miracosta.cs113;
/**
 * @author Kyle Harris (with contributions from Koffman and Wolfgang source code)
 * @version 1.0
 * */
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashTableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>
{
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 3;
	private static final double LOAD_THRESHOLD = 3.0;
	
	private static class Entry<K, V> implements Map.Entry<K, V>
	{
		private K key;
		private V value;
		
		//CONSTRUCTOR
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		/**@return this.key The key to be returned*/
		@Override
		public K getKey() 
		{
			return this.key;
		}

		/**@return this.value The value to be returned*/
		@Override
		public V getValue() 
		{
			return this.value;
		}

		/**@param value The new value to be set
		 * @return oldVal The former value to be returned*/
		@Override
		public V setValue(V value) 
		{
			V oldVal;
			oldVal = this.value;
			this.value = value;
			return oldVal;
		}
		
		/**@return key + value The String of the instance variables of the inner class*/
		public String toString()
		{
			return key + " is the key and " + value + " is the value";
		}
		
	}
	
	//CONSTRUCTOR
	public HashTableChain()
	{
		this.table = new LinkedList[this.CAPACITY];
	}

	//KW Method
	/*<listing chapter="7" number="9">*/
    /**
     * Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
	@Override
	public V get(Object key) 
	{
		int index;
		index = key.hashCode() % this.table.length;
		if(index < 0)
		{
			index += this.table.length;
		}
		
		for(Entry<K, V> nextItem : this.table[index])
		{
			if(nextItem.key.equals(key))
			{
				return nextItem.value;
			}
		}
		return null;
	}

	//KW Method
	/*<listing chapter="7" number="10">*/
    /**
     * Method put for class HashtableChain.
     * @post This key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
	@Override
	public V put(K key, V value) 
	{
		int index;
		index = key.hashCode() % this.table.length;
		if(index < 0)
		{
			index += this.table.length;
		}
		if(this.table[index] == null)
		{
			this.table[index] = new LinkedList<Entry<K, V>>();
		}
		
		for(Entry<K, V> nextItem : this.table[index])
		{
			if(nextItem.key.equals(key))
			{
				V oldVal;
				oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}
		
		this.table[index].addFirst(new Entry<K, V>(key, value));
		this.numKeys++;
		if(this.numKeys > (this.LOAD_THRESHOLD * this.table.length))
		{
			rehash();
		}
		return null;
	}
	
	/**@return output The toString of all keys and values of the hash table*/
	public String toString()
	{
		String output;
		output = "";
		for(int i = 0; i < this.table.length; i++)
		{
			if(this.table[i] != null)
			{
				for(Entry<K, V> pair : table[i])
				{
					output += pair.toString() + "\n";
				}
			}
		}
		return output;
	}
	
	/**@return this.numKeys The size of the hash table */
	@Override
	public int size()
	{
		return this.numKeys;
	}

	//Made public to more easily test, would be private otherwise
	public void rehash()
	{
		LinkedList<Entry<K, V>>[] newTable;
		newTable = new LinkedList[(this.table.length * 2) + 1];
		for(LinkedList<Entry<K, V>> list : this.table) 
		{
			if(list != null)
			{
				for(Entry<K, V> entry : list)
				{
					if(entry != null)
					{
						int hashCode;
						hashCode = (entry.getKey().hashCode()) % newTable.length;
						
						if(newTable[hashCode] == null)
						{
							newTable[hashCode] = new LinkedList<>();
						}
						newTable[hashCode].add(entry);
					}
				}
			}
		}
		this.table = newTable;
	}
	
	/**@param key The key to remove the value from
	 * @return null If the table is empty at the index value or at very end when all other operations do not return
	 * @return temp.value The value to be removed from the hash table*/
	@Override
	public V remove(Object key) 
	{
		int index;
		Iterator<Entry<K, V>> iterator;
		index = key.hashCode() % this.table.length;
		if(index < 0)
		{
			index += this.table.length;
		}
		if(this.table[index] == null)
		{
			return null;
		}
		
		iterator = this.table[index].listIterator(); 
		
		while(iterator.hasNext())
		{
			Entry<K, V> temp;
			temp = iterator.next(); 
			if(temp.getKey().equals(key))
			{
				this.numKeys--;
				iterator.remove();
				return temp.value;
			}
		}
		return null;
	}

	/**@return this.numKeys == 0 The number of keys at 0 indicates that the table is empty*/
	@Override
	public boolean isEmpty() 
	{
		return this.numKeys == 0;
	}

	/**@return new EntrySet() The new entrySet() to be returned*/
	@Override
	public Set<Map.Entry<K, V>> entrySet() 
	{
		return new EntrySet();
	}
	
	private class EntrySet extends AbstractSet<Map.Entry<K, V>>
	{
		/**@return numKeys The size of the hash table from inside EntrySet*/
		@Override
		public int size()
		{
			return numKeys;
		}
		
		/**@return new SetIterator The new SetIterator to be returned*/
		@Override
		public Iterator<Map.Entry<K, V>> iterator()
		{
			return new SetIterator();
		}
	}
	
	private class SetIterator implements Iterator<Map.Entry<K, V>>
	{
		int index = 0;
		int lastItemReturned = -1;
		Iterator<Entry<K, V>> localIterator = null;
		
		/**@return true If the localIterator has a next
		 * @return false If the index equals the table length
		 * @return this.localIterator.hasNext() Gets a boolean value of whether localIterator has a next or not*/
		@Override
		public boolean hasNext() 
		{
			if(this.localIterator != null)
			{
				if(this.localIterator.hasNext())
				{
					return true;
				}
				else
				{
					this.localIterator = null;
					this.index++;
				}
			}
			
			while(this.index < table.length && table[index] == null)
			{
				this.index++;
			}
			if(this.index == table.length)
			{
				return false;
			}
			this.localIterator = table[this.index].iterator();
			return this.localIterator.hasNext();
		}

		/**@return localIterator.next() If the localIterator has a next value or at the end if all other functions fail to return a value
		 * @return null If the index and table length are the same */
		@Override
		public Map.Entry<K, V> next() 
		{
			if(this.localIterator != null)
			{
				if(this.localIterator.hasNext())
				{
					this.lastItemReturned = this.index;
					return localIterator.next();
				}
				else
				{
					this.localIterator = null;
					this.index++;
				}
			}
				while(this.index < table.length && table[this.index] == null)
				{
					this.index++;
				}
				if(this.index == table.length)
				{
					return null;
				}
				this.localIterator = table[this.index].iterator();
				return localIterator.next();
		}
		
		/**@throws IllegalStateException If lastItemReturned is -1*/
		@Override
		public void remove()
		{	
			if(this.lastItemReturned == -1)
			{
				throw new IllegalStateException();
			}
				
			else
			{
				this.localIterator.remove();
				numKeys--;
				this.lastItemReturned = -1;
			}
		}
	}
}
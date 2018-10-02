/**
 * HashTable class with put, get, and remove methods
 * @author Benny Fung
 *
 */
public class Hashtable 
{
	private HashNode[] arr;
	private int elem;
	
	/**
	 * Initialize constructor
	 */
	public Hashtable()
	{
		elem = 0;
		arr = new HashNode[94124];
	}
	
	/**
	 * Helper function that gets index from hashtable data structure
	 * @param key
	 * @return
	 */
	private int getPosition(String key)
	{
		return Math.abs(key.hashCode()%arr.length);
	}
	
	/**
	 * Returns number of elements
	 * @return
	 */
	public int getSize()
	{
		return elem;
	}
	
	/**
	 * Adds key into data structure
	 * @param key
	 * @param val
	 */
	public void put(String key, String val) 
	{
		HashNode node = new HashNode(key, val);
		int pos = getPosition(key);
		HashNode temp = arr[pos];
		node.setNext(temp);
		arr[pos] = node;
		elem++;
	}

	/**
	 * Get value of a key
	 * @param key
	 * @return
	 */
	public Object get(String key)
	{
		int pos = getPosition(key);
		HashNode temp = arr[pos];
		while(temp!= null)
		{
			if(temp.getKey().equals(key))
			{
				return temp.getValue();
			}
			temp = temp.getNext();
		}
		return null;
	}

	/**
	 * Removes specified key and returns value
	 * @param key
	 * @return
	 */
	public String remove(String key)
	{		
		int pos = getPosition(key);
		HashNode temp = arr[pos];
		HashNode prev = null;
		
		if(temp == null)
		{
			return null;
		}
		
		if(temp.getKey().equals(key))
		{
			arr[pos] = temp.getNext();
			elem--;
			return temp.getValue();
		}
		
		while(temp.getNext() != null)
		{
			if(temp.getKey().equals(key))
			{
				String removedValue = temp.getValue();
				prev.setNext(temp.getNext());
				elem--;
				return removedValue;
			}
			prev = temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	/**
	 * Iterates through data structure and returns true/false whether if contains the key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key)
	{
		int pos = Math.abs(key.hashCode()%arr.length);
		HashNode temp = arr[pos];
		while(temp != null)
		{
			if(temp.getKey().equals(key))
			{
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
}
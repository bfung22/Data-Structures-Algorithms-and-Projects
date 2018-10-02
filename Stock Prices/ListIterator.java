/**
 * ListIterator class that contains methods that iterates through a LinkedList
 * @author Benny Fung
 *
 */
public class ListIterator
{
	private Link current;
	/**
	 * Initializes constructor
	 */
	public ListIterator()
	{
		current = null;
	}
	
	/**
	 * Initializes constructor
	 * @param head
	 */
	public ListIterator(Link head)
	{
		current = new Link(null, head);
	}
	
	/**
	 * Returns the current data
	 * @return
	 */
	public Object next()
	{
		try
		{
			current = current.getNext();
			return current.getData();
		} 
		catch (Exception e)
		{
			return null;
		}
	}
	
	/**
	 * Checks to see if there is a next element
	 * @return
	 */
	public boolean hasNext()
	{
		if (current == null)
		{
			return false;
		} 
		else
		{
			return current.getNext() != null;
		}
	}
}
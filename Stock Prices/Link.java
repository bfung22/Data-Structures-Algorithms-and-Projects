/**
 * Link class that contains the essential methods from the StockData, Object and Link classes.
 * @author Benny Fung
 *
 */
public class Link 
{
	private StockData data;
	private Link next;
	/**
	 * Initializes constructor that contains the StockData object and next Link object
	 * @param data
	 * @param newNext
	 */
	public Link(StockData data, Link newNext)
	{
		this.data = data;
		this.next = newNext;
	}
	
	/**
	 * Initializes constructor that contains StockData objects
	 * @param data
	 */
	public Link(StockData data)
	{
		this.next = null;
		this.data = data;
	}
	
	/**
	 * Getter method for StockData class object
	 * @return
	 */
	public StockData stock()
	{
		return data;
	}
	
	/**
	 * Returns object data
	 * @return
	 */
	public Object getData()
	{
		return this.data;
	}
	
	/**
	 * Gets the next Link
	 * @return
	 */
	public Link getNext()
	{
		return this.next;
	}
	
	/**
	 * Sets the StockData element 
	 * @param data
	 */
	public void setData(StockData data)
	{
		this.data = data;
	}
	
	/**
	 * Sets the next Link 
	 * @param newNode
	 */
	public void setNext(Link newNode)
	{
		this.next = newNode;
	}
}
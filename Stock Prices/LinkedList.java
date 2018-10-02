import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * LinkedList class that contains methods such as add, remove, get, print, etc.
 * @author Benny Fung
 *
 */
public class LinkedList
{
	private Link head;
	private int size;
	private Calculation calc;
	
	/**
	 * Initializes constructor of LinkedList class
	 */
	public LinkedList()
	{
		head = null;
		size = 0;
	}
	
	/**
	 * ListIterator class
	 * @return
	 */
	public ListIterator it()
	{
		return new ListIterator(head);
	}
	
	/**
	 * Checks to see if list is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/**
	 * Add StockData object at "pos" index
	 * @param pos
	 * @param data
	 */
	public void add(int pos, StockData data)
	{
		if(pos < 0 || pos > size)//check boundaries
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(head == null)
		{
			head = new Link(data);
			size++;
			return;
		}	
		
		else if(pos == size)//add to end
		{
			add(data);
			size++;
		}
		
		else //get the previous of "pos" index and update pointers
		{
			Link current = new Link(null, head);
			for(int i = 0; i < pos; i++)
			{
				current = current.getNext();
			}
			
			Link temp = new Link(data, current.getNext());
			if(pos == 0)
			{
				head = temp;
			}
			else
			{
				current = head;
				current.setNext(temp);
			}
			size++;
		}
	}
	
	/**
	 * Appends StockData objects at the end of the list
	 * @param data
	 */
	public void add(StockData data)
	{		
		Link temp = new Link(data);
		if(head == null)
		{
			head = temp;
			size++;
		}
		else
		{
			Link current = head;
			while(current.getNext()!=null)
			{
				current = current.getNext();
			}
			current.setNext(temp);
			size++;
		}
	}
	
	/**
	 * Prints the entire linked list
	 */
	public void printList()
	{
		ListIterator iterator = it();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}	
	}
	
	/**
	 * Returns outlier results if there are outliers
	 * @param list
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public String printResults(LinkedList list, Date start, Date end) throws ParseException
	{
		int count = 0;
		calc = new Calculation(list);
		String result = "";
		boolean hasOutlier = false;
		double variance = calc.getVariance(start, end);
		
		if(calc.minObservations()) //checks to see if there is a minimum of two data entries
		{
			return result = "There is insufficient data for this period.";
		}
		StockData data;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date currentDate;
		ListIterator iterator = it();
		
		while(iterator.hasNext())
		{
			data = (StockData) iterator.next();			
			currentDate = format.parse(data.getDate());
			if(currentDate.equals(start) || currentDate.after(start) && currentDate.before(end)) //if date is within boundaries
			{
				if((Double.valueOf(data.getClose())) < variance/2 || (Double.valueOf(data.getClose())) > 2*variance)
				{
					//if close data value is less than half the variance or more than twice the variance, print data
					hasOutlier = true;
					System.out.println(data.toStringDateAndClose());
					result = "The following data above depicts a total of "+ ++count +" outlier(s) for the inputted date period.";
				}
			}
		}
		
		if(hasOutlier == false)
		{
			return result = "There are no outliers.";
		}
		return result;
	}
	
	/**
	 * Returns size of the list
	 * @return
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Returns object from the index "pos"
	 * @param pos
	 * @return
	 */
	public Object get(int pos)
	{
		if(isEmpty() || pos < 0 || pos >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		else
		{
			ListIterator ite = it();
			int index = 0;
			while(ite.hasNext() && index < size)
			{
				if(index == pos)
				{
					return ite.next();
				}
				index++;
				ite.next();
			}
			return null;
		}
	}
	
	/**
	 * Removes object from the index "pos" and decrements size of list
	 * @param pos
	 * @return
	 */
	public Object remove(int pos)
	{
		Link current;
		current = head;
		Object removed;
		int index = 0;
		
		if(isEmpty() || pos < 0 || pos >= size) //check boundaries
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(pos == 0) //if pos to be removed is at the beginning of the list, update head
		{
			removed = head;
			head = head.getNext();
			size--;
			return head.getData();
		}
		while(current.getNext() != null && index < pos) //updates current to pos-1 (or previous to pos to be removed)
		{
			current = current.getNext();
			index++;
		}
		
		if(pos == size-1) //if pos is at the end of the list)
		{
			removed = current.getNext().getData();
			size--;
			return removed;
		}
		else //if pos is anywhere but the end (or beginning), update pointers
		{
			removed = current.getNext().getData();
			current.setNext(current.getNext().getNext());
			size--;
			return removed;
		}
	}
}
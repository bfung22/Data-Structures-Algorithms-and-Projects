import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calculation 
{
	private LinkedList linkedList;
	private double sum;
	private int count;
	
	/**
	 * Initializes constructor
	 * @param list
	 */
	public Calculation(LinkedList list)
	{
		linkedList = list;
		linkedList.it();
		sum = 0;
		count = 0;
	}
	
	/**
	 * Checks to see if there are a minimum of two traversed stock data entries
	 * @return
	 */
	public boolean minObservations()
	{
		return count < 2;
	}
	
	/**
	 * Returns the mean
	 * @param sum
	 * @param count
	 * @return
	 */
	public double getMean(double sum, int count)
	{
		return sum/count;
	}
	
	/**
	 * Returns the calculated variance
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public double getVariance(Date start, Date end) throws ParseException
	{
		StockData data;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date currentDate;
		double var = 0;
		ListIterator iterator = linkedList.it();
		ListIterator iterator2 = linkedList.it();
		while(iterator.hasNext())
		{
			data = (StockData) iterator.next();			
			currentDate = format.parse(data.getDate());
			if(currentDate.equals(start) || currentDate.after(start) && currentDate.before(end))
			{
				sum = sum + Double.valueOf(data.getClose());
				++count;
			}
		}
		
		double mean = getMean(sum, count);
		while(iterator2.hasNext())
		{
			data = (StockData) iterator2.next();			
			currentDate = format.parse(data.getDate());
			if(currentDate.equals(start) || currentDate.after(start) && currentDate.before(end))
			{
				var = var + Math.pow(mean - Double.valueOf(data.getClose()), 2);
			}
		}
		return var/(count-1);
	}		
}

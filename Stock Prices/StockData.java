/**
 * StockData class that contains the appropriate stock information
 * @author Benny Fung
 *
 */
public class StockData 
{
	//data types are Strings by default; will cast accordingly if used in conjunction with other data types
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String adjClose;
	private String volume;
	
	/**
	 * Initializes constructor
	 * @param date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param adjClose
	 * @param volume
	 */
	public StockData(String date, String open, String high, String low, String close, String adjClose, String volume)
	{
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjClose = adjClose;
		this.volume = volume;
	}

	/**
	 * Method that prints all the stock information in a string
	 */
	public String toString()
	{
		return "Date: " + this.date + " Open: " + this.open + " High: " + this.high + " Low: " + this.low + " Close: "
	+this.close + " adjClose: " + this.adjClose + " Volume: " + this.volume;
	}
	
	/**
	 * Returns string with the date and close values
	 * @return
	 */
	public String toStringDateAndClose()
	{
		return "Date: " + this.date + "\tClose: " + this.close;
	}
	
	/**
	 * Getter method for the date
	 * @return
	 */
	public String getDate()
	{
		return this.date;
	}
	
	/**
	 * Getter method for 'open' value
	 * @return
	 */
	public String getOpen()
	{
		return this.open;
	}
	
	/**
	 * Getter method for 'high' value
	 * @return
	 */
	public String getHigh()
	{
		return this.high;
	}
	
	/**
	 * Getter method for 'low' value
	 * @return
	 */
	public String getLow()
	{
		return this.low;
	}
	
	/**
	 * Getter method for 'close' value
	 * @return
	 */
	public String getClose()
	{
		return this.close;
	}
	
	/**
	 * Getter method for 'adjclose' value
	 * @return
	 */
	public String getAdjClose()
	{
		return this.adjClose;
	}
	
	/**
	 * Getter method for 'volume' value
	 * @return
	 */
	public String getVolume()
	{
		return this.volume;
	}
}

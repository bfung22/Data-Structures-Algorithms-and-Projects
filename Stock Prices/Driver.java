import java.io.File; 
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Driver class that runs the program with try-catch for error checking
 * @author BennyFung
 *
 */
public class Driver 
{
	public static void main(String args[])
	{
		LinkedList list = new LinkedList();
		File file;
		Scanner scan = new Scanner(System.in);
		System.out.print("Stock symbol: ");
		String stock = scan.next();

		try 
		{
			file = new File(stock + ".csv");
			Builder.traverseFile(file, list);
		}
		catch (IOException e) 
		{
			System.out.println("File '" + stock + ".csv' does not exist");
			System.exit(1);
		}
		
		try
		{
			Calendar calendar = Calendar.getInstance();
			System.out.println("Date (YYYY-MM-DD): ");
			String inputDate = scan.next();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date startDate = format.parse(inputDate);
			calendar.setTime(startDate);
			calendar.add(Calendar.YEAR, 1);
			Date endDate = calendar.getTime();
			System.out.println(list.printResults(list, startDate, endDate));
		}
		catch (ParseException e)
		{
			System.out.println("Error in parsing date");
			System.exit(1);
		}
		scan.close();
	}
}
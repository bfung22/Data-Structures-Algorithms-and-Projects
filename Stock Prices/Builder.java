import java.io.File; 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * Builder class that reads in file and adds data into linked list structure
 * @author Benny Fung
 *
 */
public class Builder 
{
	/**
	 * File to traverse
	 * @param file
	 * @param list
	 * @throws IOException
	 */
	public static void traverseFile(File file, LinkedList list) throws IOException
	{
		traverse(file, list);
	}
	
	/**
	 * Traverses the file and adds objects to the linked list.
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static LinkedList traverse(File file, LinkedList list) throws IOException
	{				
		List<String> lines = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
		Iterator<String> it = lines.iterator();
		if(it.hasNext())
		{
			//skips first line (category descriptions)
			it.next();
		}
		while(it.hasNext())
		{
			//delimits by commas and adds object to linked list
			String[] split = it.next().toString().split(",");
			int count = 0;
			while(count < split.length)
			{
				String date = split[count++];
				String open = split[count++];
				String high = split[count++];
				String low = split[count++];
				String close = split[count++];
				String adjClose = split[count++];
				String volume = split[count++];
				list.add(new StockData(date, open, high, low, close, adjClose, volume));	
			}
		}
		return list;	
    }
}

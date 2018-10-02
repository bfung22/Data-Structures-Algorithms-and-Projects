/**
 * Node class with getters and setters
 * @author BennyFung
 *
 */
public class HashNode
{
	private String key;
	private String value;
	private HashNode next;
	
	public HashNode(String k, String v)
	{
		key = k;
		value = v;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public HashNode getNext()
	{
		return next;
	}
	
	public void setNext(HashNode next)
	{
		this.next = next;
	}
}

/**
 * BinaryHeap with add and remove method along with other helper methods
 * @author Benny Fung
 *
 */
public class BinaryHeap
{
	private int arr[];
	private int size;
	/**
	 * initialize constructor
	 */
	public BinaryHeap()
	{
		size = 0;
		arr = new int[10];
	}
	
	/**
	 * Adds value to heap; grows if heap reaches limit
	 * @param i
	 */
	public void add(int i)
	{
		if(arr.length == size)
		{
			growHeap();
		}
		arr[size++] = i;
		int index = size - 1;
		while(index > 0 && arr[index] < arr[parent(index)])
		{
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	/**
	 * Swaps the two parameters
	 * @param a
	 * @param b
	 */
	private void swap(int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	 * Parent of "index"
	 * @param index
	 * @return
	 */
	private int parent(int index)
	{
		return (index-1)/2;
	}
	
	/**
	 * Left child of "index"
	 * @param index
	 * @return
	 */
	private int leftChild(int index)
	{
		return (index*2)+1;
	}
	
	/**
	 * Right child of "index"
	 * @param index
	 * @return
	 */
	private int rightChild(int index)
	{
		return (index*2)+2;
	}
	
	/**
	 * Doubles size and grows the heap
	 */
	private void growHeap()
	{
		int[]newArr = new int[arr.length*2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	/**
	 * Removes first element(highest priority) of array 
	 * @return
	 */
	public int remove()
	{		
		int temp = arr[0];
		arr[0]= arr[--size];
		bubbleDown(0);
		return temp;
	}
	
	/**
	 * Recursive method that swaps the children or parent depending on priority
	 * @param index
	 */
	private void bubbleDown(int index)
	{
		if(leftChild(index)<size)
		{
			int child = leftChild(index);
			if(rightChild(index)<size && arr[rightChild(index)] < arr[child])
			{
				child = rightChild(index);
			}
			if(arr[index] > arr[child])
			{
				swap(index, child);
			}
			bubbleDown(child);
		}
	}
}
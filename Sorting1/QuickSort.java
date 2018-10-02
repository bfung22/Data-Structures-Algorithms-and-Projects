
public class QuickSort implements SortingAlgorithm
{
	@Override
	public void sort(int[] a) 
	{
		qsort(a, 0, a.length-1);		
	}
	
	public void qsort(int[]a, int top_index, int bot_index)
	{
		//Call partition to divide the array. Everything above pivot is smaller than everything below.
		int pivot = partition(a, top_index, bot_index);
		// Recursively call quick sort on the top and bottom sub-arrays.
		if (top_index < pivot-1)  // Base case 1: must have at least 1 element to sort
		{
			qsort(a, top_index, pivot-1);
		}
		
		if (pivot < bot_index)    // Base case 2: same for the bottom subarray
		{
			qsort(a, pivot, bot_index);
		}
	}
	
	public int partition(int [] a, int top_index, int bot_index)
	{
		int i = top_index;  
		int j = bot_index;
		int pivot = (top_index + bot_index)/2; // One of several pivot selection strategies.
		
		while (i<=j) 
		{
			//Find a large value (greater than pivot) in the start of the (sub-)array
			while (a[i] < a[pivot])
			{
				i++;
			}
			// Find a small value in the end of the (sub-)array
			while (a[j] > a[pivot])
			{
				j--;
			}
			// swap values when appropriate
			if (i <= j)
			{
				// keep track of the pivot
				if (i == pivot)
				{
					pivot=j;
				}
				else if (j == pivot)
				{
					pivot=i;
				}
				swap(a, i++, j--);
			}
		}
		//Return the pivot location
		return i;
	}
	
	private void swap(int[]a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

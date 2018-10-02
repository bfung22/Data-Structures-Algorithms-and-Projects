	
public class MergeSort implements SortingAlgorithm
{
	private int[] tempArr;
	
	@Override
	public void sort(int[] a)
	{
		this.tempArr = new int[a.length];
		mergeSort(a, 0, a.length-1);
	}
	
	public void mergeSort(int[] a, int low, int high){
		if (high > low)
		{
			int middle = (low + high)/2;
			mergeSort(a, low, middle);
			mergeSort(a, middle+1, high);
			merge(a, low, middle, high);
		}	
	}

	public void merge(int[] a, int bot, int middle, int top)
	{		
		for (int i = bot; i <= top;i++)
		{
			tempArr[i] = a[i];
		}
		
		int bot_index = bot;
		int top_index = middle+1;
		int index = bot;
		
		while (bot_index <= middle && top_index <=top)
		{
			if (tempArr[bot_index] <= tempArr[top_index])
			{
				a[index] = tempArr[bot_index];
				bot_index++;
			}
			
			else
			{
				a[index] = tempArr[top_index];
				top_index++;
			}
			
			index++;		
		}
		
		int length = middle-bot_index;
		for (int i = 0; i <= length; i++)
		{
			a[index+i] = tempArr[bot_index+i];
		}
	}
}

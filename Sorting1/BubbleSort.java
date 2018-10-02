
public class BubbleSort implements SortingAlgorithm
{
	@SuppressWarnings("unused")
	@Override
	public void sort(int[] a)
	{
		boolean swapped = true;
		for (int j = 0; j < a.length-1; j++)
		{
			swapped = false;
			for (int i = 0; i < a.length-1-j; i++)
			{
				swapped = false;
				if (a[i] > a[i+1])
				{
					swap(a, i, i+1);
					swapped = true;
				}
			}
		}
	}

	void swap(int[]a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

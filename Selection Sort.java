class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min_index = i;
        for(int j = i + 1; j < arr.length; j++)
        {
            if(arr[j] < arr[min_index])
                min_index = j;
        }
        return min_index;
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i = 0; i < n ; i++)
	    {
	       int index = select(arr, i);
	       
	       int temp = arr[i];
	       arr[i] = arr[index];
	       arr[index] = temp;
	    }
	    
	    
	}
}

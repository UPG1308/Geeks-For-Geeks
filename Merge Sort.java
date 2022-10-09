class Solution
{
    void merge(int arr[], int low, int mid, int right)
    {
         // Your code here
         int n1 = mid - low + 1, n2 = right - mid;
         
         int arr1[] = new int[n1];
         int arr2[] = new int[n2];
         int k = 0;
         for(int i = 0; i < n1; i++) arr1[i] = arr[low + i];
         for(int i = 0; i < n2; i++) arr2[i] = arr[mid + i + 1];
         
         int i = 0, j = 0;
         k = low;
         while(i < n1 && j < n2)
         {
             if(arr1[i] <= arr2[j])
             {
                 arr[k] = arr1[i];
                 i++;
                 k++;
             }
             else 
             {
                 arr[k] = arr2[j];
                 j++;
                 k++;
             }
         }
         
         while(i < n1) 
         {
             arr[k] = arr1[i];
             i++;
             k++;
         }
         
         while(j < n2) 
         {
             arr[k] = arr2[j];
             j++;
             k++;
         }
    }
    
    
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(r > l)
        {
            int mid = l + (r - l)/2;
            
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l , mid, r);
        }
    }
}

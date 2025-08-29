// Last updated: 29/08/2025, 22:28:42
class Solution {
    public void rotate(int[] arr, int k) {
        int n=arr.length;
        k %= n;
        
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }

    public void reverse(int[] arr, int low, int high)
    {
        while(low<high){
            int temp= arr[low];    
            arr[low]= arr[high];
            arr[high]= temp;
            low++;
            high--;
        }
    }
}
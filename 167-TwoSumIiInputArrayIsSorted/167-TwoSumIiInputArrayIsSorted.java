// Last updated: 24/01/2026, 00:10:09
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n= arr.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int sum= arr[low]+arr[high];
            if(sum==target)
                break;   
            else if(sum > target){
                high--;
            }
            else
                low++;
        }
        int[] res= { low+1, high+1};
        return res;
    }
}
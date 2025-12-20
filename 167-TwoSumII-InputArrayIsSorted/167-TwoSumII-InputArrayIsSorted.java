// Last updated: 20/12/2025, 19:23:32
1class Solution {
2    public int[] twoSum(int[] arr, int target) {
3        int n= arr.length;
4        int low=0;
5        int high=n-1;
6        while(low<high){
7            int sum= arr[low]+arr[high];
8            if(sum==target)
9                break;   
10            else if(sum > target){
11                high--;
12            }
13            else
14                low++;
15        }
16        int[] res= { low+1, high+1};
17        return res;
18    }
19}
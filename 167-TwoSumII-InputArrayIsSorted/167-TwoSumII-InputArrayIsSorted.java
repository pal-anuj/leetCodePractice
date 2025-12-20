// Last updated: 20/12/2025, 19:23:13
1class Solution {
2    public int[] twoSum(int[] arr, int target) {
3        int n= arr.length;
4        int min= 0;
5        int i;
6        int low=0;
7        int high=n-1;
8        while(low<high){
9            int sum= arr[low]+arr[high];
10            if(sum==target)
11                break;   
12            else if(sum > target){
13                high--;
14            }
15            else
16                low++;
17        }
18        int[] res= { low+1, high+1};
19        return res;
20    }
21}
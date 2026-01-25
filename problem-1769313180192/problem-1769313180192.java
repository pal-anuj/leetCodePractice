// Last updated: 25/01/2026, 09:23:00
1class Solution {
2    public int minimumPrefixLength(int[] nums) {
3   
4        int n= nums.length-1;
5        for(int i=n-1;i>=0;i--){
6             if(nums[i] < nums[i+1])
7                continue;
8            else
9                return i+1;
10        }
11    
12        return 0;
13        
14    }
15}
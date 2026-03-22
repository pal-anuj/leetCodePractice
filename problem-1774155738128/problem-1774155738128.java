// Last updated: 22/03/2026, 10:32:18
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int oddCount=0;
4        int evenCount=0;
5        for(int num : nums1){
6            if((num % 2) == 0)
7                evenCount++;
8            else
9                oddCount++;
10        }
11        return true;
12    }
13}
// Last updated: 25/04/2026, 10:39:51
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] leftPrefix = new int[n];
5        leftPrefix[0] = 1;
6        for (int i = 1; i < n; i++) {
7            leftPrefix[i] = leftPrefix[i-1] * nums[i-1];
8        }
9
10        int[] res = new int[n];
11        int rightSuffix = 1;
12        for (int i = n-1; i >= 0; i--) {            
13            res[i]= leftPrefix[i] * rightSuffix;  
14            rightSuffix *= nums[i];
15        }
16
17        return res;
18    }
19}
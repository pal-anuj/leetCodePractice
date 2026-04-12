// Last updated: 12/04/2026, 18:19:39
1class Solution {
2    public int maxSubArray(int[] nums) {
3        int n = nums.length;
4        int curr = nums[0];
5        int maxSum = curr;
6        for (int i = 1; i < n; i++) {
7            curr += nums[i];
8            curr = Math.max(curr, nums[i]);
9            maxSum = Math.max(maxSum, curr);
10        }
11        return maxSum;
12
13
14        
15    }
16}
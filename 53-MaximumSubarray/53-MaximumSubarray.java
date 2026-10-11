// Last updated: 12/10/2026, 01:21:55
1class Solution {
2    public int maxSubArray(int[] nums) {
3
4        int curSum = nums[0];
5        int maxSum = nums[0];
6
7        for (int i = 1; i < nums.length; i++) {
8            curSum = Math.max(nums[i], curSum + nums[i]);
9            maxSum = Math.max(maxSum, curSum);
10        }
11
12        return maxSum;
13    }
14}
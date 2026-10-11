// Last updated: 12/10/2026, 01:18:28
1class Solution {
2    public int maxSubArray(int[] nums) {
3
4        int curSum = nums[0];
5        int maxSum = curSum;
6        for (int i = 1; i < nums.length; i++) {
7            curSum += nums[i];
8            if (curSum < nums[i]) {
9                curSum = nums[i];
10            }
11            if (maxSum < curSum) {
12                maxSum = curSum;
13            }
14        }
15        return maxSum;
16    }
17}
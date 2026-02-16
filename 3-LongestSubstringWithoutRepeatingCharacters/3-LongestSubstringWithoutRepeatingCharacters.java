// Last updated: 16/02/2026, 08:55:54
1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3        int sum = 0;
4        for (int i = 0; i < k; i++) {
5            sum += nums[i];
6        }
7
8        int maxSum = sum;
9        for (int i = k; i < nums.length; i++) {
10            sum = sum + nums[i] - nums[i-k];
11            maxSum = Math.max(maxSum, sum);
12        }
13
14        return (double) maxSum / k;
15    }
16}
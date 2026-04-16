// Last updated: 16/04/2026, 05:37:03
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
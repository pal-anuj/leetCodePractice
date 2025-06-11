// Last updated: 11/06/2025, 17:43:55
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currentSum=0;
        int n = nums.length;
        for(int i=0; i<n;i++){
            currentSum +=nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum<0)
                currentSum=0;
        }
        return maxSum;
    }
}
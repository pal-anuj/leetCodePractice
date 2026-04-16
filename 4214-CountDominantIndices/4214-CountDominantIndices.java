// Last updated: 16/04/2026, 05:36:30
class Solution {
    public int dominantIndices(int[] nums) {
        int count = 0;
        int n = nums.length;
        int prevSum = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            int rightCount= n-i-1;
            
            if ((long) nums[i]*rightCount > prevSum) {
                count++;
            }

            prevSum+= nums[i];
        }
        return count;
    }
}
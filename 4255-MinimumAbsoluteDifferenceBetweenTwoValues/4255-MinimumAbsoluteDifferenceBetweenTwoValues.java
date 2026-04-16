// Last updated: 16/04/2026, 05:36:15
class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] == 1 && nums[j] == 2) || (nums[i] == 2 && nums[j] == 1))
                    minDiff = Math.min(minDiff, Math.abs(i - j));
            }
        }
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}
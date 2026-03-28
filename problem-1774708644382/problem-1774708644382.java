// Last updated: 28/03/2026, 20:07:24
1class Solution {
2    public int minAbsoluteDifference(int[] nums) {
3        int n = nums.length;
4        int minDiff = Integer.MAX_VALUE;
5        for (int i = 0; i < n - 1; i++) {
6            for (int j = i + 1; j < n; j++) {
7                if ((nums[i] == 1 && nums[j] == 2) || (nums[i] == 2 && nums[j] == 1))
8                    minDiff = Math.min(minDiff, Math.abs(i - j));
9            }
10        }
11        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
12    }
13}
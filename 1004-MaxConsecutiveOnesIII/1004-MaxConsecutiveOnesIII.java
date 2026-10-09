// Last updated: 10/10/2026, 01:37:57
1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        int maxCount = 0;
4        int l = 0;
5        int zeros = 0;
6        for (int r = 0; r < nums.length; r++) {
7            if (nums[r] == 0) {
8                zeros++;
9            }
10
11            while (zeros > k) {
12                if (nums[l] == 0) {
13                    zeros--;
14                }
15                l++;
16            }
17
18            maxCount = Math.max(maxCount, r - l + 1);
19        }
20        return maxCount;
21    }
22}
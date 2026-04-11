// Last updated: 11/04/2026, 08:01:15
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int n = nums.length;
4        int[] res = new int[2];
5        for (int i = 0; i < n - 1; i++) {
6            for (int j = i + 1; j < n; j++) {
7                if (nums[i] + nums[j] == target) {
8                    res[0] = i;
9                    res[1] = j;
10                    return res;
11                }
12            }
13        }
14        return res;
15    }
16}
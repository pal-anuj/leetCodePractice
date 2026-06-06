// Last updated: 06/06/2026, 20:41:08
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int n = nums.length;
4        // bruet force
5        int[] res = new int[2];
6        for (int i = 0; i < n - 1; i++) {
7            for (int j = i + 1; j < n; j++) {
8                if (nums[i] + nums[j] == target) {
9                    res[0] = i;
10                    res[1] = j;
11                    return res;
12                }
13            }
14        }
15        return res;
16    }
17}
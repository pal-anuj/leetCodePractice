// Last updated: 26/05/2026, 23:47:53
1class Solution {
2    public boolean check(int[] nums) {
3        int n= nums.length;
4        int count = 0;
5        for (int i = 0; i < nums.length; i++) {
6            if (nums[i] > nums[(i + 1) % n]) {
7                count++;
8            }
9        }
10
11        return count <= 1;
12    }
13}
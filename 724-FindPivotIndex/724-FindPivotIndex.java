// Last updated: 06/02/2026, 00:33:07
1class Solution {
2    public int pivotIndex(int[] nums) {
3
4        int totalSum = 0;
5        for (int i = 0; i < nums.length; i++) {
6            totalSum += nums[i];
7        }
8
9        int leftSum = 0;
10        for (int i = 0; i < nums.length; i++) {
11            if (leftSum == totalSum - leftSum - nums[i])
12                return i;
13            leftSum += nums[i];
14        }
15        return -1;
16    }
17}
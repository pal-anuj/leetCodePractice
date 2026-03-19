// Last updated: 19/03/2026, 23:17:29
1class Solution {
2    public void sortColors(int[] nums) {
3
4        // Brute force approach, TimeComplexity O(n2) 
5        for (int i = 0; i < nums.length; i++) {
6            for (int j = 0; j < nums.length - 1; j++) {
7                if (nums[j] > nums[j + 1]) {
8                    int temp = nums[j];
9                    nums[j] = nums[j + 1];
10                    nums[j + 1] = temp;
11                }
12            }
13        }
14    }
15}
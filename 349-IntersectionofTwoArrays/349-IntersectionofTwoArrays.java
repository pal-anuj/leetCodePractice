// Last updated: 08/06/2026, 18:48:50
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        int[] arr = new int[n + 1];
5
6        for (int num : nums) {
7            if (num > 0 && num <= n)
8                arr[num] = 1;
9        }
10
11        for (int i = 1; i <= n; i++) {
12            if (arr[i] == 0)
13                return i;
14        }
15        return n+1;
16    }
17}
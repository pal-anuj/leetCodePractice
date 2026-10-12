// Last updated: 12/10/2026, 12:44:40
1class Solution {
2    public int minStartValue(int[] nums) {
3        int sum = 0;
4        int minSum = 0;
5        for (int num : nums) {
6            sum += num;
7            minSum = Math.min(minSum, sum);
8        }
9        // System.out.println(minSum);
10        return 1 - minSum;
11    }
12}
// Last updated: 20/05/2026, 09:55:08
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] lprefix = new int[n + 1];
5        lprefix[0] = 1;
6        for (int i = 0; i < n; i++) {
7            lprefix[i + 1] = lprefix[i] * nums[i];
8        }
9
10        int rsuffix = 1;
11        int[] res = new int[n];
12        for (int i = n - 1; i >= 0; i--) {
13            res[i] = lprefix[i] * rsuffix;
14            rsuffix *= nums[i];
15        }
16        return res;
17    }
18}
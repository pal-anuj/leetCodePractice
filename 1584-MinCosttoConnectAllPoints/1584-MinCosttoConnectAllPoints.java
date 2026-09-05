// Last updated: 05/09/2026, 05:51:13
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] prefix = new int[n + 1];
5        prefix[0] = 1;
6        for (int i = 1; i <= n; i++) {
7            prefix[i] = prefix[i - 1] * nums[i - 1];
8        }
9
10        int[] res = new int[n];
11        int suffix = 1;
12        for (int i = n - 1; i >= 0; i--) {
13            res[i] = prefix[i] * suffix;
14            suffix *= nums[i];
15        }
16
17        return res;
18    }
19}
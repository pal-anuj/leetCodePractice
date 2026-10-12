// Last updated: 12/10/2026, 12:33:55
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] prefix = new int[n + 1];
5        prefix[0] = 1;
6
7        // 1, 1, 2, 2, 6, 24
8        for (int i = 0; i < n; i++) {
9            prefix[i + 1] = prefix[i] * nums[i];
10        }
11
12        int[] res = new int[n];
13        res[n - 1] = prefix[n - 1];
14        int product = nums[n - 1];
15        for (int i = n - 2; i >= 0; i--) {
16            res[i] = prefix[i] * product;
17            product *= nums[i];
18        }
19
20        return res;
21    }
22}
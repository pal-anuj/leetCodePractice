// Last updated: 28/06/2026, 09:01:11
1class Solution {
2    public long maxSum(int[] nums, int k, int mul) {
3        int n = nums.length;
4        Arrays.sort(nums);
5
6        long res = 0;
7        int use = Math.min(k, Math.max(0, mul - 1));
8
9        int idx = nums.length - 1;
10
11        // Use beneficial multipliers (>1)
12        for (int i = 0; i < use; i++) {
13            res += 1L * nums[idx--] * (mul--);
14        }
15
16        // Remaining selected elements are simply added
17        while (k > use) {
18            res += nums[idx--];
19            k--;
20        }
21
22        return res;
23    }
24}
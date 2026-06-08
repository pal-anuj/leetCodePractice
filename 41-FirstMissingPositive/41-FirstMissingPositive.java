// Last updated: 08/06/2026, 21:37:23
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n; i++) {
5            if (nums[i] <= 0 || nums[i] > n) {
6                nums[i] = n + 1;
7            }
8        }
9
10        for (int i = 0; i < n; i++) {
11            int num = Math.abs(nums[i]);
12            if (num > n) {
13                continue;
14            }
15            num--;
16            if (nums[num] > 0) {
17                nums[num] = -1 * nums[num];
18            }
19        }
20
21        for (int i = 0; i < n; i++) {
22            if (nums[i] >= 0)
23                return i + 1;
24        }
25        return n + 1;
26    }
27}
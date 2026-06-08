// Last updated: 08/06/2026, 22:00:53
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        // Cycle Sort Appaorach Time: O(2n), space O(n)
5        int i = 0;
6        while (i < n) {
7            if (nums[i] > 0 && nums[i] <= n
8                    && nums[i] != nums[nums[i] - 1]) {
9                swap(nums, i, nums[i] - 1);
10            } else {
11                i++;
12            }
13        }
14
15        for (i = 0; i < n; i++) {
16            if (nums[i] != i + 1)
17                return i + 1;
18        }
19        return n + 1;
20
21        // Interview Approach Time O(3n), space: O(n)
22        // for (int i = 0; i < n; i++) {
23        //     if (nums[i] <= 0 || nums[i] > n) {
24        //         nums[i] = n + 1;
25        //     }
26        // }
27
28        // for (int i = 0; i < n; i++) {
29        //     int num = Math.abs(nums[i]);
30        //     if (num > n) {
31        //         continue;
32        //     }
33        //     num--;
34        //     if (nums[num] > 0) {
35        //         nums[num] = -1 * nums[num];
36        //     }
37        // }
38
39        // for (int i = 0; i < n; i++) {
40        //     if (nums[i] >= 0)
41        //         return i + 1;
42        // }
43        // return n + 1;
44    }
45
46    void swap(int[] nums, int i, int j) {
47        int temp = nums[j];
48        nums[j] = nums[i];
49        nums[i] = temp;
50    }
51}
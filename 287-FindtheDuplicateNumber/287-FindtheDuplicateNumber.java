// Last updated: 22/08/2026, 00:52:04
1class Solution {
2    public int findDuplicate(int[] nums) {
3        int n = nums.length;
4        int i = 0;
5        while (i < n) {
6
7            int correctIndex = nums[i] - 1;
8            if (nums[i] != nums[correctIndex]) { // if element is not its position correct it
9                int temp = nums[i];
10                nums[i] = nums[correctIndex];
11                nums[correctIndex] = temp;
12            } else {
13                i++;
14            }
15        }
16
17        for (i = 0; i < n; i++) {
18            if (nums[i] != i + 1)
19                return nums[i];
20        }
21        return -1;
22    }
23}
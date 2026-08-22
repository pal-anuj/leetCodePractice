// Last updated: 22/08/2026, 20:30:08
1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4        int l = 0;
5        int h = n - 1;
6
7        while (l <= h) {
8            int mid = l + (h - l) / 2;
9            if (nums[mid] == target)
10                return mid;
11            else if (nums[mid] < target)
12                l = mid + 1;
13            else
14                h = mid - 1;
15        }
16        return -1;
17    }
18}
// Last updated: 22/02/2026, 07:37:35
1class Solution {
2    public int search(int[] nums, int target) {
3        int l = 0;
4        int r = nums.length-1;
5
6        while (l <= r) {
7            int mid = l + (r - l) / 2;
8
9            if (nums[mid] > target) {
10                r = mid - 1;
11            } else if (nums[mid] < target) {
12                l = mid + 1;
13            } else
14                return mid;
15        }
16
17        return -1;
18    }
19}
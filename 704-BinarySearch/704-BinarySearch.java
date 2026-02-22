// Last updated: 22/02/2026, 08:25:23
1class Solution {
2    public int search(int[] nums, int target) {
3        int l = 0;
4        int r = nums.length - 1;
5
6        while (l <= r) {
7            int mid = l + (r - l) / 2;
8
9            if (nums[mid] == target)
10                return mid;
11            else if (nums[l] <= nums[mid]) {
12
13                if (nums[mid] > target && nums[l] <= target) {
14                    r = mid - 1;
15                } else {
16                    l = mid + 1;
17                }
18            } else {
19                if (nums[mid] < target && nums[r] >= target)
20                    l = mid + 1;
21                else
22                    r = mid - 1;
23            }
24        }
25
26        return -1;
27    }
28}
// Last updated: 06/05/2026, 22:45:03
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int n = nums.length;
4        int left = 0;
5        int right = nums.length - 1;
6
7        int leftidx = -1;
8        while (left <= right) {
9            int mid = left + (right - left) / 2;
10            if (nums[mid] == target) {
11                leftidx = mid;
12                right = mid - 1;
13            } else if (nums[mid] > target) {
14                right = mid - 1;
15            } else {
16                left = mid + 1;
17            }
18        }
19        int rightidx = leftidx;
20        for (int i = leftidx + 1; i < n; i++) {
21            if (nums[i] != target)
22                break;
23            else
24                rightidx = i;
25        }
26        int res[] = new int[2];
27        res[0] = leftidx;
28        res[1] = rightidx;
29        return res;
30    }
31}
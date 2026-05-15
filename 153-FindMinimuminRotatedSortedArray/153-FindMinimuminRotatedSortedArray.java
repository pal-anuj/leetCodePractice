// Last updated: 15/05/2026, 09:21:29
1class Solution {
2
3    public int findMin(int[] nums) {
4        int l = 0;
5        int r = nums.length - 1;
6        int res = Integer.MAX_VALUE;
7        while (l <= r) {
8            int mid = l + (r - l) / 2;
9
10            if(nums[l] <= nums[r]){
11                res= Math.min(res, nums[l]);
12                break;
13            }
14
15            if (nums[l] <= nums[mid]) {
16                res = Math.min(res, nums[l]);
17                l = mid + 1;
18            } else {
19                r = mid - 1;
20                res = Math.min(res, nums[mid]);
21            }
22
23        }
24        return res;
25    }
26}
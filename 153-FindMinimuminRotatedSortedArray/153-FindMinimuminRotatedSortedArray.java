// Last updated: 15/05/2026, 09:15:13
1class Solution {
2
3    /*
4    [4,5,6,7,0,1,2] l=0, r=7 mid= 7/2=> 3
5    res=7
6    nums[l] > nums[mid]
7    
8    
9     */
10    public int findMin(int[] nums) {
11        int l = 0;
12        int r = nums.length - 1;
13        int res = Integer.MAX_VALUE;
14        while (l <= r) {
15            int mid = l + (r - l) / 2;
16            if (nums[l] <= nums[mid]) {
17                res = Math.min(res, nums[l]);
18                l = mid + 1;
19            } else {
20                r = mid - 1;
21                res = Math.min(res, nums[mid]);
22            }
23
24        }
25        return res;
26    }
27}
// Last updated: 06/05/2026, 22:30:49
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int l=0;
4        int r=nums.length-1;
5        int res=nums.length;
6        while(l<=r){
7            int mid= l+(r-l)/2;
8            if(nums[mid] >= target){
9                res=mid;
10                r= mid-1;
11            }
12            else{
13                l= mid+1;
14            }
15        }
16        return res;
17
18    }
19}
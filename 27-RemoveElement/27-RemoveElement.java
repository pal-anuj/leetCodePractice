// Last updated: 13/12/2025, 23:56:46
1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int n= nums.length;
4        int count=0;
5        for(int i=0;i<n;i++){
6            if(nums[i]!=val)
7                nums[count++]=nums[i];
8        }
9        return count;
10    }
11}
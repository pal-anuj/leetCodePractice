// Last updated: 13/08/2026, 22:35:38
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int n= nums.length;
4        int l= 0;
5        for(int r=0;r<n;r++){
6            if(nums[r]!=0){
7                swap(l++, r, nums);
8            }
9        }
10    }
11
12    private static void swap(int i,int j, int[] nums){
13        int temp= nums[i];
14        nums[i]= nums[j];
15        nums[j]= temp;
16    }
17}
// Last updated: 13/12/2025, 23:55:00
1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int n= nums.length;
4        int[] arr= new int[n];
5        int count=0;
6        for(int i=0;i<n;i++){
7            if(nums[i]!=val)
8                arr[count++]=nums[i];
9        }
10
11        for(int i=0;i<n;i++)
12            nums[i]= arr[i];
13        return count;
14        
15    }
16}
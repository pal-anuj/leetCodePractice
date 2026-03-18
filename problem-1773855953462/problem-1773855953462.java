// Last updated: 18/03/2026, 23:15:53
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int[] res= new int[2];
4
5        for(int i=0;i<nums.length-1;i++){
6            for(int j=i+1;j<nums.length;j++){
7                if(nums[i]+nums[j]==target){
8                    res[0]= i;
9                    res[1]= j;
10                    return res;
11                }
12            }
13        }
14        return res;
15    }
16}
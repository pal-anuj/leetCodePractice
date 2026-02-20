// Last updated: 20/02/2026, 20:23:50
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int[] res= new int[2];
4        for(int i=0;i<nums.length;i++){
5            for(int j=i+1;j<nums.length;j++){
6                if(nums[i] + nums[j]==target){
7                    res[0]= i;
8                    res[1]= j;
9                    break;
10                }    
11            }
12        }
13        return res;
14
15    }
16}
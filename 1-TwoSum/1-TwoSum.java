// Last updated: 11/06/2025, 17:44:03
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j]==target){
                    res[0]= i;
                    res[1]= j;
                    break;
                }    
            }
        }
        return res;

    }
}
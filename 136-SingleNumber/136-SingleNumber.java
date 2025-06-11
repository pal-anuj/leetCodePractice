// Last updated: 11/06/2025, 17:43:49
class Solution {
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i=0; i<nums.length;i++)
            res = res ^ nums[i];
            
        return res;
    }
}
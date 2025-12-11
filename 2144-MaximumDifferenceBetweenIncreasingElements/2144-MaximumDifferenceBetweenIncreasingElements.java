// Last updated: 11/12/2025, 09:57:13
class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int res=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]> min && nums[i]-min >res)
                res= nums[i]-min;

            if(nums[i] < min)
                min= nums[i];
        }
        return res;
    }
}
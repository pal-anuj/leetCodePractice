// Last updated: 16/11/2025, 19:16:15
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
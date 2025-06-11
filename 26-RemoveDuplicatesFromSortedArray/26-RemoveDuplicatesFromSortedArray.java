// Last updated: 11/06/2025, 17:43:57
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;     
        int idx = 1; 
      
        for (int i = 1; i < nums.length; i++) 
        {
            if (nums[i] != nums[i - 1]) {
               
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
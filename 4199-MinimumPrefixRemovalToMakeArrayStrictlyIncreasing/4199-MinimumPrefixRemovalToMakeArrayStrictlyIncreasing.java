// Last updated: 16/04/2026, 05:36:33
class Solution {
    public int minimumPrefixLength(int[] nums) {
   
        int n= nums.length-1;
        for(int i=n-1;i>=0;i--){
             if(nums[i] < nums[i+1])
                continue;
            else
                return i+1;
        }
    
        return 0;
        
    }
}
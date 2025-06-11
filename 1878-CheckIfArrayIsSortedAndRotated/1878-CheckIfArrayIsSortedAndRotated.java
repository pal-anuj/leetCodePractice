// Last updated: 11/06/2025, 17:43:33
class Solution {
    public boolean check(int[] nums) {
        
        int count =0;
        boolean flag=false;

        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]> nums[(i+1)%nums.length])
                count = count+1;
        }

        if(count<=1)
            flag=true;

        return flag;
    }
}
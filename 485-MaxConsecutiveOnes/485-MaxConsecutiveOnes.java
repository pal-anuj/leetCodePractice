// Last updated: 11/06/2025, 17:43:37
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count =0; 
        for(int i =0; i<nums.length; i++)
        {
           if(nums[i]!=1)
                count=0;     
            else{

                count= count+1;
                if(count>max)
                    max=count;
            }

        }

        return max;
    }
}
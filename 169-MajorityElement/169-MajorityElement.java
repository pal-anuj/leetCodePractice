// Last updated: 11/06/2025, 17:43:48
class Solution {
    public int majorityElement(int[] nums) {

        int count =1; int res=0;
        for(int i =1; i<nums.length;i++){
            if(nums[res]==nums[i])
                count++;
            else{
                count--;
                if(count==0){
                    res=i;
                    count=1;
                }
            }                   
        }


        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[res]==nums[i])
                count++;
        }
        if(count <= nums.length/2)
            return -1;

        return nums[res];            
    }
}
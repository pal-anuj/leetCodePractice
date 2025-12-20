// Last updated: 20/12/2025, 20:02:24
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] flag=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(flag[n]){
                return n;
            }
            flag[n]=true;
        }
        return -1;
    }
}
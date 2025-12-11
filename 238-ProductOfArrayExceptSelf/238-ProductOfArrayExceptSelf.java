// Last updated: 11/12/2025, 09:57:26
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] leftPr= new int[n];
        leftPr[0]=1;
        for(int i=1;i<n;i++){
            leftPr[i]=leftPr[i-1]*nums[i-1];
        }
        
        int[] res= new int[n];
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            res[i]= leftPr[i]*suffix;
            suffix= suffix*nums[i];
        }
        return res;
    }

}
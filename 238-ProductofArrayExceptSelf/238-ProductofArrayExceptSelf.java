// Last updated: 29/08/2025, 23:50:32
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] leftPr= new int[n];
        leftPr[0]=1;
        for(int i=1;i<n;i++){
            leftPr[i]=leftPr[i-1]*nums[i-1];
        }

        int[] rightPr= new int[n];
        rightPr[n-1]=1;
        for(int i=n-2;i>=0;i--){
            rightPr[i]=rightPr[i+1]*nums[i+1];
        }

        int[] res= new int[n];
        for(int i=0;i<n;i++){
            res[i]= leftPr[i] * rightPr[i];
        }

        return res;
    }

}
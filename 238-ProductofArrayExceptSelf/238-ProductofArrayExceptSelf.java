// Last updated: 14/12/2025, 00:31:26
1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3
4       int n=nums.length; 
5       int[] lPro= new int[n];
6       lPro[0]=1;
7       for(int i=1;i<n;i++){
8            lPro[i]= lPro[i-1]*nums[i-1];
9       }
10
11       int[] res= new int[n];
12       int suffix=1;
13       for(int i=n-1;i>=0;i--){
14            res[i]= lPro[i]*suffix;
15            suffix= suffix*nums[i];
16       }
17       return res;
18    }
19}
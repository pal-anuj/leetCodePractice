// Last updated: 26/07/2026, 21:43:23
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int n= nums.length;
4        int res=0;
5        int prefix=0;
6        
7        for(int i=0;i<n;i++){
8            int sum=0;
9            for(int j=i;j<n;j++){
10                sum+= nums[j];
11                if(sum==k){
12                    res++;
13                }
14            }
15        }
16        return res;
17    }
18}
// Last updated: 10/08/2026, 07:58:37
1class Solution {
2    public int maxArea(int[] height) {
3        int n= height.length-1;
4        int res=0;
5        int l=0;
6        int r=n;
7
8        while(l<r){
9            int minh= Math.min(height[l], height[r]);
10            res= Math.max( res ,minh*(r-l));
11
12            if(height[l] < height[r]){
13                l++;
14            }else{
15                r--;
16            }
17        }
18        return res;
19    }
20}
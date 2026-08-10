// Last updated: 10/08/2026, 07:57:27
1class Solution {
2    public int maxArea(int[] height) {
3        int n= height.length-1;
4        int res=0;
5        int l=0;
6        int r=n;
7
8        while(l<r){
9            if(height[l] < height[r]){
10                int minh= Math.min(height[l], height[r]);
11                res= Math.max( res ,minh*(r-l));
12                l++;
13            }else{
14                int minh= Math.min(height[l], height[r]);
15                res= Math.max( res ,minh*(r-l));
16                r--;
17            }
18        }
19        return res;
20    }
21}
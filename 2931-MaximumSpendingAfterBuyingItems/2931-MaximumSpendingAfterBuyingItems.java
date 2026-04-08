// Last updated: 08/04/2026, 22:59:54
1class Solution {
2    public int trap(int[] height) {
3        int n= height.length;    
4        int[] leftMax= new int[n];
5        leftMax[0]= height[0];
6        for(int i=1;i<n;i++)
7            leftMax[i]= Math.max(height[i], leftMax[i-1]);
8
9        int[] rightMax= new int[n];
10        rightMax[n-1]= height[n-1];
11        for(int i=n-2; i>=0;i--)
12            rightMax[i]= Math.max(height[i], rightMax[i+1]);
13
14        int count=0;
15        for(int i=1; i<n-1;i++)
16            count += Math.min(rightMax[i], leftMax[i]) - height[i];
17
18        return count;                
19    }
20}
// Last updated: 22/12/2025, 00:52:03
1class Solution {
2    public int maxArea(int[] height) {
3        int n= height.length;
4        int lp=0; //left pointer
5        int rp=n-1; //right pointer
6        int maxw=0; // max water container
7
8        while(lp<rp){
9
10            int ht= Math.min(height[lp], height[rp]); //min height
11            int w= rp-lp; // width
12            int currw= ht*w;    // current water container
13            maxw= Math.max(maxw, currw);
14
15            if(height[lp] < height[rp]) 
16                lp++;
17            else 
18                rp--;
19        }
20        
21        return maxw;
22    }
23}
// Last updated: 22/12/2025, 00:38:29
1class Solution {
2    public int maxArea(int[] height) {
3        int n= height.length;
4        int[] lmax= new int[n];
5        lmax[0]= height[0];
6        for(int i=1;i<n;i++){
7            lmax[i]= Math.max(lmax[i-1], height[i]);
8        }
9        
10        int[] rmax= new int[n];
11        rmax[n-1]= height[n-1];
12        for(int i=n-2;i >= 0;i--){
13            rmax[i]= Math.max(rmax[i+1], height[i]);
14        }
15
16
17        int low=0;
18        int high=n-1;
19        int maxw=0;
20        while(low<high){
21            System.out.println("low="+low+", high="+high);
22            int min= Math.min(lmax[low], rmax[high]);
23            int minw= min*(high-low);
24            maxw= Math.max(maxw, minw);
25
26            if(height[low]<height[high])
27                low++;
28            else
29                high--;
30        }
31        return maxw;
32    }
33}
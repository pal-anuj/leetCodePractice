// Last updated: 11/01/2026, 13:00:06
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int top=-1;

        int[] stack = new int[n];

        for(int i =0;i<=n;i++){
           int curr = (i==n) ? 0:heights[i];

           while(top!=-1 && curr < heights[stack[top]]){
            int h = heights[stack[top--]];
            int leftBoundry = (top==-1) ? -1:stack[top];
            int width = i-leftBoundry-1;
            max = Math.max(max,h*width);
           }
           if(i<n){
            stack[++top]=i;
           }
        }
        return max;
    }
}

//[2,1,5,6,2,3]

//max = 1







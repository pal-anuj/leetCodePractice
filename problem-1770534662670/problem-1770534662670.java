// Last updated: 08/02/2026, 12:41:02
1class Solution {
2    public int dominantIndices(int[] nums) {
3        int count = 0;
4        int n = nums.length;
5        int prevSum = nums[n - 1];
6
7        for (int i = n - 2; i >= 0; i--) {
8
9            int rightCount= n-i-1;
10            
11            if ((long) nums[i]*rightCount > prevSum) {
12                count++;
13            }
14
15            prevSum+= nums[i];
16        }
17        return count;
18    }
19}
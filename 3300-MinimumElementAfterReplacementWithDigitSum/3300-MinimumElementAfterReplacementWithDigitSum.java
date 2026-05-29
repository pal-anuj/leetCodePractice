// Last updated: 29/05/2026, 19:38:20
1class Solution {
2    public int minElement(int[] nums) {
3
4        int res = Integer.MAX_VALUE;
5
6        for (int num : nums) {
7            int newNum = 0;            
8            if (num > 9) {
9                while (num > 0) {
10                    newNum += num % 10;
11                    num /= 10;
12                }
13            }
14            else
15                newNum = num; 
16
17            res = Math.min(res, newNum);
18        }
19        return res;
20    }
21}
// Last updated: 01/02/2026, 15:56:14
1class Solution {
2    public int countMonobit(int n) {
3        int count = 1;
4        int num = 1;
5
6        while (num <= n) {
7            count++;
8            num = (num << 1) | 1;
9        }
10        return count;
11    }
12}
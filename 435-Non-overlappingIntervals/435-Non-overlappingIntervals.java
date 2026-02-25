// Last updated: 25/02/2026, 06:35:24
1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3        int n = intervals.length;
4        if (n <= 1)
5            return 0;
6        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
7        int count = 1;
8        int lastEnd = intervals[0][1];
9        System.out.println("lastEnd1= "+ lastEnd);
10        for (int i = 1; i < n; i++) {
11            if (intervals[i][0] >= lastEnd) {
12                count++;
13                lastEnd = intervals[i][1];
14                System.out.println("lastEnd= "+ lastEnd);
15            }
16        }
17        
18        // [[1,2],[2,3],[3,4],[1,3]]
19        // sorting -> [[1,2],[1,3],[2,3],[3,4]]
20        // Sort by End -> [[3,4],[2,3],[1,3],[1,2]]
21
22        return n - count;
23    }
24}
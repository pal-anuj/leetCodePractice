// Last updated: 23/02/2026, 06:02:12
1class Solution {
2    public int[][] merge(int[][] intervals) {
3        if (intervals.length <= 1)
4            return intervals;
5
6        // ascending sort - strating point 
7        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
8
9        List<int[]> res = new ArrayList<>();
10
11        int[] newInterval = intervals[0];
12        res.add(newInterval);
13
14        for (int[] interval : intervals) {
15            if (interval[0] <= newInterval[1]) {
16                // overlapping intervals
17                // updating the end if needed
18                newInterval[1] = Math.max(newInterval[1], interval[1]);
19            } else {
20                // disjoint intervals
21                // add the new interval to the list 
22                newInterval = interval;
23                res.add(newInterval);
24            }
25        }
26        return res.toArray(new int[res.size()][]);
27    }
28}
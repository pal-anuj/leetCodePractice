// Last updated: 12/10/2026, 20:23:58
1class Solution {
2    public int[][] merge(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
4
5        List<int[]> res = new ArrayList<>();
6        int[] cur = intervals[0];
7        for (int i = 1; i < intervals.length; i++) {
8            if (intervals[i][0] <= cur[1]) {
9                cur[1] = Math.max(cur[1], intervals[i][1]);
10            } else {
11                res.add(cur);
12                cur = intervals[i];
13            }
14        }
15        res.add(cur);
16
17        return res.toArray(new int[res.size()][]);
18    }
19}
// Last updated: 28/06/2026, 17:05:21
1class Solution {
2    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
3        int n = occupiedIntervals[0].length;
4        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
5
6        List<int[]> merged = new ArrayList<>();
7
8        for (int[] cur : occupiedIntervals) {
9            if (merged.isEmpty()) {
10                merged.add(new int[] { cur[0], cur[1] });
11                continue;
12            }
13
14            int[] last = merged.get(merged.size() - 1);
15
16            if (cur[0] <= last[1]+1) {
17                last[1] = Math.max(last[1], cur[1]);
18            } else {
19                merged.add(new int[] { cur[0], cur[1] });
20            }
21        }
22
23        List<List<Integer>> res = new ArrayList<>();
24        for (int[] interval : merged) {
25            int start = interval[0];
26            int end = interval[1];
27
28            // no overlap    
29            if (end < freeStart || start > freeEnd) {
30                res.add(Arrays.asList(start, end));
31            }
32            // Free interval completely covers occupied interval
33            else if (start >= freeStart && end <= freeEnd) {
34                continue;
35            }
36            // Free interval is inside occupied interval -> split into two
37            else if (start < freeStart && end > freeEnd) {
38                res.add(Arrays.asList(start, freeStart - 1));
39                res.add(Arrays.asList(freeEnd + 1, end));
40            }
41            // Overlap on the left
42            else if (start >= freeStart) {
43                res.add(Arrays.asList(freeEnd + 1, end));
44            }
45            // Overlap on the right
46            else {
47                res.add(Arrays.asList(start, freeStart - 1));
48            }
49
50        }
51
52        return res;
53
54    }
55}
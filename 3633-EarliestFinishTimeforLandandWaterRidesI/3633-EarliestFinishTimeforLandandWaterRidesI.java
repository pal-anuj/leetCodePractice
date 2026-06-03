// Last updated: 03/06/2026, 23:32:50
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3            int[] waterStartTime, int[] waterDuration) {
4
5        int n = landStartTime.length;
6        int m = waterStartTime.length;
7
8        int ans = Integer.MAX_VALUE;
9
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j < m; j++) {
12
13                // Land -> Water
14                int landFinish = landStartTime[i] + landDuration[i];
15                int waterBegin = Math.max(landFinish, waterStartTime[j]);
16                ans = Math.min(ans, waterBegin + waterDuration[j]);
17
18                // Water -> Land
19                int waterFinish = waterStartTime[j] + waterDuration[j];
20                int landBegin = Math.max(waterFinish, landStartTime[i]);
21                ans = Math.min(ans, landBegin + landDuration[i]);
22            }
23        }
24
25        return ans;
26    }
27}
// Last updated: 03/06/2026, 00:31:04
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3
4        int n = landStartTime.length;
5        int m = waterStartTime.length;
6        int totalTime = Integer.MAX_VALUE;
7
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < m; j++) {
10                int curTotalTime = 0;
11                if (landStartTime[i] < waterStartTime[j]) {
12                    curTotalTime = landStartTime[i] + landDuration[i];
13                    if (waterStartTime[j] < curTotalTime) {
14                        curTotalTime += waterDuration[j];
15                    } else {
16                        int diff = waterStartTime[j] - curTotalTime;
17                        curTotalTime += diff + waterDuration[j];
18                    }
19                    totalTime = Math.min(totalTime, curTotalTime);
20                } else {
21                    curTotalTime = waterStartTime[j] + waterDuration[j];
22                    if (landStartTime[i] < curTotalTime) {
23                        curTotalTime += landDuration[i];
24                    } else {
25                        int diff = landStartTime[i] - curTotalTime;
26                        curTotalTime += diff + landDuration[i];
27                    }
28                    totalTime = Math.min(totalTime, curTotalTime);
29                }
30            }
31        }
32        return totalTime;
33    }
34}
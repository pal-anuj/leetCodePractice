// Last updated: 08/10/2026, 01:07:11
1class Solution {
2    public int shipWithinDays(int[] weights, int days) {
3        int n = weights.length;
4        int minW = 0;
5        int maxW = 0;
6        for (int i = 0; i < n; i++) {
7            maxW += weights[i];
8            if (weights[i] > minW) {
9                minW = weights[i];
10            }
11        }
12
13        int l = minW;
14        int h = maxW;
15        int res = 0;
16        while (l <= h) {
17            int mid = l + (h - l) / 2;
18            // System.out.println(mid);
19            int daysReq = possibleDays(weights, mid);
20            if (daysReq <= days) {
21                res = mid;
22                h = mid - 1;
23            } else if (daysReq > days) {
24                l = mid + 1;
25            }
26        }
27        return res;
28
29        // for(int cap= minW;cap<=maxW;cap++){
30        //     int daysReq= possibleDays(weights, cap);
31        //     // System.out.println("cap:"+cap+", daysreq:"+daysReq);
32        //     if(daysReq <= days)
33        //         return cap;
34        // }
35        // return maxW;
36    }
37
38    private int possibleDays(int[] weights, int cap) {
39        int load = 0;
40        int days = 1;
41        for (int i = 0; i < weights.length; i++) {
42            if (load + weights[i] > cap) {
43                days++;
44                load = weights[i];
45            } else {
46                load += weights[i];
47            }
48
49        }
50        return days;
51    }
52}
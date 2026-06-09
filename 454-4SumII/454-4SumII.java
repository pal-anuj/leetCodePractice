// Last updated: 09/06/2026, 21:30:33
1class Solution {
2    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
3        int n = nums1.length;
4        int tuples = 0;
5        Map<Integer, Integer> map = new HashMap<>(); // sum -> frequency
6        for (int i = 0; i < n; i++) {
7            for (int j = 0; j < n; j++) {
8                int sum = nums1[i] + nums2[j];
9                map.put(sum, map.getOrDefault(sum, 0) + 1);
10            }
11        }
12
13        for (int i = 0; i < n; i++) {
14            for (int j = 0; j < n; j++) {
15                int target = 0 - (nums3[i] + nums4[j]);
16                if (map.containsKey(target)) {
17                    tuples += map.get(target);
18                }
19            }
20        }
21
22        // // Brute force Approach Time: O(n4)
23        // for (int i = 0; i < n; i++) {
24        //     for (int j = 0; j < n; j++) {
25        //         for (int k = 0; k < n; k++) {
26        //             for (int l = 0; l < n; l++) {
27        //                 if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0)
28        //                     tuples++;
29        //             }
30        //         }
31        //     }
32        // }
33
34        return tuples;
35    }
36}
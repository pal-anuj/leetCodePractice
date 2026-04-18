// Last updated: 18/04/2026, 21:11:40
1class Solution {
2    public int totalFruit(int[] fruits) {
3        int n = fruits.length;
4        int max = 0;
5        // efficient approach
6        HashMap<Integer, Integer> map = new HashMap<>();
7        int l = 0;
8        for (int r = 0; r < fruits.length; r++) {
9            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
10
11            if (map.size() > 2) {
12                while (map.size() > 2) {
13                    map.put(fruits[l], map.get(fruits[l]) - 1);
14                    if (map.get(fruits[l]) == 0)
15                        map.remove(fruits[l]);
16                    l++;
17                }
18            } else {
19                int count = 0;
20                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
21                    count += entry.getValue();
22                }
23                max = Math.max(max, count);
24            }
25        }
26
27        // // brute force time: O(n2)
28        // for (int i = 0; i < n; i++) {
29        //     Set<Integer> set = new HashSet<>();
30        //     int count = 0;
31        //     for (int j = i; j < n; j++) {
32        //         set.add(fruits[j]);
33        //         if (set.size() > 2)
34        //             break;
35        //         count++;
36        //     }
37        //     max = Math.max(max, count);
38        // }
39
40        return max;
41    }
42}
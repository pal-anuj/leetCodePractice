// Last updated: 15/03/2026, 18:56:25
1class Solution {
2    public int minCost(int[] nums1, int[] nums2) {
3        Map<Integer,Integer> map= new HashMap<>();
4        for(int num : nums1)
5            map.put(num, map.getOrDefault(num, 0) + 1);
6
7        for(int num : nums2)
8            map.put(num, map.getOrDefault(num, 0) - 1);
9
10        int swap=0;
11        for(int v : map.values()){
12            if(Math.abs(v) % 2 != 0)
13                return -1;
14
15            swap += Math.abs(v) / 2;
16        }
17        return swap / 2;
18    }
19}
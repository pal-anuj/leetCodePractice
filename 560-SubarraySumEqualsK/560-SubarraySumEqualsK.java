// Last updated: 19/02/2026, 06:37:49
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3
4        Map<Integer, Integer> map = new HashMap<>();
5        map.put(0, 1);
6        int sum = 0;
7        int count = 0;
8        for (int num : nums) {
9            //logic using map
10            sum += num;
11            count += map.getOrDefault(sum - k, 0);
12            map.put(sum, map.getOrDefault(sum, 0) + 1);
13        }
14        return count;
15
16    }
17}
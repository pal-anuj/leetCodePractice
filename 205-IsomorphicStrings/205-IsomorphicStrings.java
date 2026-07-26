// Last updated: 26/07/2026, 23:18:49
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int n = nums.length;
4        Map<Integer, Integer> map = new HashMap<>();
5        map.put(0, 1);
6
7        int prefix = 0;
8        int count = 0;
9        for (int num : nums) {
10            prefix += num;
11            if (map.containsKey(prefix - k)) {
12                count += map.get(prefix - k);
13            }
14            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
15        }
16
17        return count;
18    }
19}
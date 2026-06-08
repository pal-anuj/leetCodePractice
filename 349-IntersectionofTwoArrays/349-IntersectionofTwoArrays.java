// Last updated: 08/06/2026, 18:37:21
1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        List<Integer> res = new ArrayList<>();
4        Map<Integer, Boolean> map = new HashMap<>();
5        for (int num : nums1)
6            map.put(num, false);
7
8        int j = 0;
9        for (int num : nums2) {
10            if (map.containsKey(num) && map.get(num) == false) {
11                res.add(num);
12                map.put(num, true);
13            }
14        }
15        return res.stream()
16                .mapToInt(Integer::intValue)
17                .toArray();
18    }
19}
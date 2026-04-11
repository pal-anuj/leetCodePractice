// Last updated: 11/04/2026, 08:04:58
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int n = nums.length;
4        int[] res = new int[2];
5        Map<Integer, Integer> map = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            int diff = target - nums[i];
8            if (map.containsKey(diff)) {
9                res[0] = map.get(diff);
10                res[1] = i;
11                break;
12            }
13            map.put(nums[i], i);
14        }
15        return res;
16    }
17}
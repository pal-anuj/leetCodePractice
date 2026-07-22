// Last updated: 22/07/2026, 23:31:20
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        for (int i = 0; i < nums.length; i++) {
5            int diff = target - nums[i];
6            if (map.containsKey(diff)) {
7                return new int[] { map.get(diff), i };
8            }
9            map.put(nums[i], i);
10        }
11        return new int[0];
12    }
13}
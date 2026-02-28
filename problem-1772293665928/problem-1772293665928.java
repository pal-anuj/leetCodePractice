// Last updated: 28/02/2026, 21:17:45
1class Solution {
2    public int[] minDistinctFreqPair(int[] nums) {
3        Arrays.sort(nums);
4
5        int[] res = new int[2];
6        res[0] = nums[0];
7
8        Map<Integer, Integer> freq = new HashMap<>();
9        for (int i = 0; i < nums.length; i++) {
10            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
11        }
12
13        for (int i = 1; i < nums.length; i++) {
14            if (res[0] != nums[i] && freq.get(nums[i]) != freq.get(res[0])) {
15                res[1] = nums[i];
16                return res;
17            }
18        }
19
20        return new int[] { -1, -1 };
21
22    }
23}
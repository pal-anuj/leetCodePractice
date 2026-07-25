// Last updated: 25/07/2026, 14:18:42
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> res = new ArrayList<>();
5        Set<List<Integer>> set = new HashSet<>();
6        for (int i = 0; i < n - 2; i++) {
7            int target = 0 - nums[i];
8            Map<Integer, Integer> idxMap = new HashMap<>();
9            for (int j = i + 1; j < n; j++) {
10                int diff = target - nums[j];
11                if (idxMap.containsKey(diff)) {
12                    List<Integer> ls = new ArrayList<>(Arrays.asList(nums[i], nums[j], diff));
13                    ls.sort(Integer::compareTo);
14                    if (!set.contains(ls)) {
15                        res.add(new ArrayList<>(ls));
16                        set.add(ls);
17                    }
18                }
19                idxMap.put(nums[j], j);
20            }
21        }
22
23        return res;
24    }
25}
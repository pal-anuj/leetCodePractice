// Last updated: 17/09/2026, 06:41:21
1class Solution {
2    Set<List<Integer>> set = new HashSet<>();
3
4    public List<List<Integer>> subsetsWithDup(int[] nums) {
5        List<List<Integer>> res = new ArrayList<>();
6        List<Integer> ds = new ArrayList<>();
7
8        subsetsWithDupRec(0, nums.length, res, ds, nums);
9        return res;
10    }
11
12    private void subsetsWithDupRec(int idx, int n, List<List<Integer>> res,
13            List<Integer> ds, int[] nums) {
14        // Base case
15        if (idx == n) {
16            List<Integer> sorted = new ArrayList<>(ds);
17            Collections.sort(sorted);
18            if (!set.contains(sorted)) {
19                res.add(new ArrayList<>(ds));
20                set.add(sorted);
21            }
22
23            return;
24        }
25
26        // Take
27        ds.add(nums[idx]);
28        subsetsWithDupRec(idx + 1, n, res, ds, nums);
29
30        // Undo
31        ds.remove(ds.size() - 1);
32
33        // Not take
34        subsetsWithDupRec(idx + 1, n, res, ds, nums);
35    }
36
37}
// Last updated: 17/09/2026, 06:15:12
1class Solution {
2
3    Set<List<Integer>> set = new HashSet<>();
4
5    public List<List<Integer>> subsets(int[] nums) {
6        List<List<Integer>> res = new ArrayList<>();
7        List<Integer> ds = new ArrayList<>();
8        return subsetsRec(0, nums.length, ds, res, nums);
9    }
10
11    List<List<Integer>> subsetsRec(int idx, int n, List<Integer> ds, List<List<Integer>> res, int[] nums) {
12        if (idx == n) {
13            if (!set.contains(ds))
14                res.add(new ArrayList<>(ds));
15            return res;
16        }
17
18        // Take
19        ds.add(nums[idx]);
20        subsetsRec(idx + 1, n, ds, res, nums);
21
22        // Undo
23        ds.remove(ds.size() - 1);
24
25        // Not take
26        subsetsRec(idx + 1, n, ds, res, nums);
27
28        return res;
29    }
30}
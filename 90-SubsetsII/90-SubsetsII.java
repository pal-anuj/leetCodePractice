// Last updated: 18/09/2026, 23:30:45
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<Integer> ds = new ArrayList<>();
4        List<List<Integer>> res = new ArrayList<>();
5        combinationSumRec(0, target, candidates, ds, res);
6        return res;
7    }
8
9    private void combinationSumRec(int idx, int target, int[] candidates, List<Integer> ds, List<List<Integer>> res) {
10        if (target == 0) {
11            res.add(new ArrayList<>(ds));
12            return;
13        }
14        if (target < 0)
15            return;
16        if (idx == candidates.length)
17            return;
18
19        // Take
20        ds.add(candidates[idx]);
21        combinationSumRec(idx, target - candidates[idx], candidates, ds, res);
22
23        // Undo
24        ds.remove(ds.size() - 1);
25
26        // not take
27        combinationSumRec(idx + 1, target, candidates, ds, res);
28    }
29}
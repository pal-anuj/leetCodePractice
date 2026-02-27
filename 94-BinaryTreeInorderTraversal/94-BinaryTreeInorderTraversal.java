// Last updated: 27/02/2026, 08:30:01
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3
4        List<List<Integer>> res = new ArrayList<>();
5        backtrack(candidates, target, 0, new ArrayList<>(), res);
6        return res;
7    }
8
9    private void backtrack(int[] arr, int target, int start, List<Integer> curr, List<List<Integer>> res) {
10
11        if (target == 0) {
12            res.add(new ArrayList<>(curr));
13            return;
14        }
15
16        if (target < 0)
17            return;
18
19        for (int i = start; i < arr.length; i++) {
20            curr.add(arr[i]);
21            backtrack(arr, target - arr[i], i, curr, res);
22            curr.remove(curr.size() - 1);
23        }
24
25    }
26
27}
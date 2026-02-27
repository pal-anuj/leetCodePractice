// Last updated: 27/02/2026, 05:31:34
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        backTrack(0, nums, new ArrayList<>(), res);
5        return res;
6    }
7
8    private void backTrack(int idx, int[] nums, ArrayList<Integer> curr, List<List<Integer>> res) {
9        if (idx == nums.length) {
10            res.add(new ArrayList<>(curr));
11            return;
12        }
13
14        // include
15        curr.add(nums[idx]);
16        backTrack(idx + 1, nums, curr, res);
17
18        // exclude
19        curr.remove(curr.size() - 1);
20        backTrack(idx + 1, nums, curr, res);
21    }
22}
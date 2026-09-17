// Last updated: 17/09/2026, 07:02:22
1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        Arrays.sort(nums);
4        List<List<Integer>> res = new ArrayList<>();
5        List<Integer> ds = new ArrayList<>();
6
7        subsetsWithDupRec(0, nums.length, res, ds, nums);
8        return res;
9    }
10
11    private void subsetsWithDupRec(int idx, int n, List<List<Integer>> res,
12            List<Integer> ds, int[] nums) {
13        // Every state is a valid subset
14        res.add(new ArrayList<>(ds));
15
16        for (int i = idx; i < n; i++) {
17
18            // Skip duplicate choices at the same level, like [2] once added , [2] is not needed
19            if (i > idx && nums[i] == nums[i - 1])
20                continue;
21
22            // Take
23            ds.add(nums[i]);
24            subsetsWithDupRec(i + 1, n, res, ds, nums);
25            // Undo
26            ds.remove(ds.size() - 1);
27        }
28
29    }
30
31    // // simple recursion
32    // private void subsetsWithDupRec1(int idx, int n, List<List<Integer>> res,
33    //         List<Integer> ds, int[] nums) {
34    //     // Base case
35    //     if (idx == n) {
36    //         List<Integer> sorted = new ArrayList<>(ds);
37    //         Collections.sort(sorted);
38    //         if (!set.contains(sorted)) {
39    //             res.add(new ArrayList<>(ds));
40    //             set.add(sorted);
41    //         }
42
43    //         return;
44    //     }
45
46    //     // Take
47    //     ds.add(nums[idx]);
48    //     subsetsWithDupRec(idx + 1, n, res, ds, nums);
49
50    //     // Undo
51    //     ds.remove(ds.size() - 1);
52
53    //     // Not take
54    //     subsetsWithDupRec(idx + 1, n, res, ds, nums);
55    // }
56
57}
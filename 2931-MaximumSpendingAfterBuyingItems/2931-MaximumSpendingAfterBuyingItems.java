// Last updated: 19/06/2026, 20:40:50
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> res = new ArrayList<>();
5        Set<List<Integer>> set = new HashSet<>();
6
7        Arrays.sort(nums);
8        for (int i = 0; i < n; i++) {
9            if (i > 0 && nums[i] == nums[i - 1])
10                continue;
11
12            int l = i + 1;
13            int r = n - 1;
14            while (l < r) {
15                int sum = nums[i] + nums[l] + nums[r];
16                if (sum > 0) {
17                    r--;
18                } else if (sum < 0) {
19                    l++;
20                } else {
21                    ArrayList<Integer> ls = 
22                                new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
23
24                    // Collections.sort(ls);
25                    if (!set.contains(ls)) {
26                        set.add(ls);
27                        res.add(ls);
28                    }
29                    l++;
30                }
31            }
32        }
33        return res;
34    }
35}
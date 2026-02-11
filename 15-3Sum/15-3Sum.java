// Last updated: 11/02/2026, 06:00:48
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> res = new ArrayList<>();
5        Set<List<Integer>> set = new HashSet<>();
6
7        Arrays.sort(nums);
8        for (int i = 0; i < n; i++) {
9            int diff = 0 - nums[i];
10            int l = i + 1;
11            int r = n - 1;
12            while (l < r) {
13                if (nums[l] + nums[r] > diff) {
14                    r--;
15                } else if (nums[l] + nums[r] < diff) {
16                    l++;
17                } else {
18                    ArrayList<Integer> ls = 
19                                new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
20
21                    Collections.sort(ls);
22                    if (!set.contains(ls)) {
23                        set.add(ls);
24                        res.add(ls);
25                    }
26                    l++;
27                }
28            }
29        }
30        return res;
31    }
32}
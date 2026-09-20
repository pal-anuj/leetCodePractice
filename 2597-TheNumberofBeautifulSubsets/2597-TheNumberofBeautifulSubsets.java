// Last updated: 20/09/2026, 19:18:23
1class Solution {
2    HashMap<Integer, Integer> freq = new HashMap<>();
3
4    public int beautifulSubsets(int[] nums, int k) {
5        return beautifulSubsets(nums, k, 0) - 1;
6    }
7
8    private int beautifulSubsets(int[] nums, int k, int idx) {
9
10        // Reached the end
11        // One valid subset has been formed
12        if (idx == nums.length)
13            return 1;
14
15        // not take current element
16        int count = beautifulSubsets(nums, k, idx + 1);
17
18        // 2. Take current element if it doesn't conflict
19        int num = nums[idx];
20
21        if (!freq.containsKey(num - k) && !freq.containsKey(num + k)) {
22
23            // Take
24            freq.put(num, freq.getOrDefault(num, 0) + 1);
25
26            count += beautifulSubsets(nums, k, idx + 1);
27
28            // backtrack
29            freq.put(num, freq.getOrDefault(num, 0) - 1);
30            if (freq.get(num) == 0)
31                freq.remove(num);
32
33        }
34
35        return count;
36    }
37}
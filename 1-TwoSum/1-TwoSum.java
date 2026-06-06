// Last updated: 06/06/2026, 20:46:25
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int n = nums.length;
4        int[] res = new int[2];
5        HashMap<Integer, Integer> map = new HashMap<>();
6        map.put(nums[0], 0);
7        for (int i = 1; i < n; i++) {
8            int diff = target - nums[i];
9            if (map.containsKey(diff)) {
10                res[0] = map.get(diff);
11                res[1] = i;
12                return res;
13            }
14            map.put(nums[i], i);
15        }
16        return res;
17
18        // // bruet force
19        // int[] res = new int[2];
20        // for (int i = 0; i < n - 1; i++) {
21        //     for (int j = i + 1; j < n; j++) {
22        //         if (nums[i] + nums[j] == target) {
23        //             res[0] = i;
24        //             res[1] = j;
25        //             return res;
26        //         }
27        //     }
28        // }
29        // return res;
30    }
31}
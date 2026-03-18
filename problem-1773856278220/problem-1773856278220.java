// Last updated: 18/03/2026, 23:21:18
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int[] res = new int[2];
4
5        //efficient approach timeComplecity = O(n), spaceComplexity = O(n)
6        Map<Integer, Integer> map = new HashMap<>();
7        map.put(nums[0], 0);
8        for (int i = 1; i < nums.length; i++) {
9            int diff = target - nums[i];
10            if (map.containsKey(diff)) {
11                res[0] = map.get(diff);
12                res[1] = i;
13                return res;
14            }
15            map.put(nums[i], i);
16        }
17
18        // // Brute force time complexity - O(n2)
19        // for(int i=0;i<nums.length-1;i++){
20        //     for(int j=i+1;j<nums.length;j++){
21        //         if(nums[i]+nums[j]==target){
22        //             res[0]= i;
23        //             res[1]= j;
24        //             return res;
25        //         }
26        //     }
27        // }
28        return res;
29    }
30}
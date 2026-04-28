// Last updated: 28/04/2026, 23:28:01
1class Solution {
2    public int findMaxLength(int[] nums) {
3        int maxlen = 0;
4        int sum = 0;
5        Map<Integer, Integer> map = new HashMap<>();
6        for (int i = 0; i < nums.length; i++) {
7            sum += nums[i] == 0 ? -1 : 1;
8            if (sum == 0) {
9                int curlen = i + 1;
10                maxlen = Math.max(maxlen, curlen);
11            } else if (map.containsKey(sum)) {
12                int curlen = i - map.get(sum);
13                maxlen = Math.max(maxlen, curlen);
14            } else
15                map.put(sum, i);
16        }
17        return maxlen;
18
19        // // bruet force
20        // int maxCount;
21        // for(int i=0;i<n;i++){
22        //     int sum=0;
23        //     for(int j=i;j<n;j++){
24        //         sum+= nums[j];
25        //         if(sum==0 &&  maxCount < j-i+1)
26        //             maxCount= j-i+1;
27        //     }
28        // }
29        // return maxCount;
30    }
31}
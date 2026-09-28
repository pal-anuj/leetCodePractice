// Last updated: 28/09/2026, 21:28:39
1class Solution {
2
3        private int nonAdjacent(int[] nums, int start, int end){
4        int prev= 0;
5        int prev2=0;
6
7        for(int i=start;i<=end;i++){
8            int pick= nums[i];
9            if(i>1) 
10                pick+= prev2;
11
12            int notPick= prev;
13            int cur= Math.max(pick, notPick);
14            prev2= prev;
15            prev=cur;    
16        }
17
18        return prev;
19    }
20
21
22    public int rob(int[] nums) {
23        int n = nums.length;
24        if (n == 1)
25            return nums[0];
26
27        return Math.max(nonAdjacent(nums, 0, n - 2), nonAdjacent(nums, 1, n - 1));
28
29        // here we're using addition to list, we can avoid that by using above approach
30        // int n = nums.length;
31        // List<Integer> ls1 = new ArrayList<>();
32        // List<Integer> ls2 = new ArrayList<>();
33
34        // for (int i = 0; i < n; i++) {
35        //     if (i != 0)
36        //         ls1.add(nums[i]);
37        //     if (i != n - 1)
38        //         ls2.add(nums[i]);
39        // }
40        // if(n==1)
41        //     return nums[0];
42
43        // return Math.max(nonAdjacent(ls1), nonAdjacent(ls2));
44    }
45
46
47
48    // // non adjacent problem solution
49    // public int nonAdjacent(List<Integer> ls) {
50    //     int n = ls.size();
51    //     int prev = ls.get(0);
52    //     int prev2 = 0;
53
54    //     for (int i = 1; i < n; i++) {
55    //         int pick = ls.get(i);
56    //         if (i > 1)
57    //             pick += prev2;
58    //         int notPick = prev;
59
60    //         int cur = Math.max(pick, notPick);
61    //         prev2 = prev;
62    //         prev = cur;
63    //     }
64
65    //     return prev;
66    // }
67}
// Last updated: 07/06/2026, 11:33:13
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n = nums.length;
4
5        // > n/2  -> keep 1 candidate
6        // > n/3  -> keep 2 candidates
7        // > n/k  -> keep k-1 candidates
8        // Boyer-Moore Voting Algorithm
9        int count1 = 0;
10        int candidate1 = 0;
11        int count2 = 0;
12        int candidate2 = 0;
13        List<Integer> res = new ArrayList<>();
14        for (int num : nums) {
15            if (num == candidate1) {
16                count1++;
17            } else if (num == candidate2) {
18                count2++;
19            } else if (count1 == 0) {
20                candidate1 = num;
21                count1 = 1;
22            } else if (count2 == 0) {
23                candidate2 = num;
24                count2 = 1;
25            } else {
26                count1--;
27                count2--;
28            }
29        }
30
31        count1 = 0;
32        count2 = 0;
33        for (int num : nums) {
34            if (num == candidate1) {
35                count1++;
36            } else if (num == candidate2) {
37                count2++;
38            }
39        }
40        // System.out.println(candidate1 + " -> " + count1);
41        // System.out.println(candidate2 + " -> " + count2);
42        if (count1 > n / 3)
43            res.add(candidate1);
44        if (count2 > n / 3)
45            res.add(candidate2);
46
47        return res;
48    }
49}
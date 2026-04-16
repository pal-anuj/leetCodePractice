// Last updated: 16/04/2026, 06:18:46
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxL = 0;
4
5        // Efficient Approach
6        int left = 0;
7        HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
8
9        for (int right = 0; right < s.length(); right++) {
10            char c = s.charAt(right);
11            if (lastSeenIndex.containsKey(c)) {
12                left = Math.max(left, lastSeenIndex.get(c)+1);
13            }
14
15            lastSeenIndex.put(c, right);
16            maxL = Math.max(maxL, right - left + 1);
17        }
18
19        // // brute force
20        // for(int i=0;i<s.length();i++){
21        //     int count=1;
22        //     Set<Character> set= new HashSet<>();
23        //     set.add(s.charAt(i));
24        //     for(int j=i+1;j<s.length();j++){
25        //         if(set.contains(s.charAt(j)))
26        //             break;
27        //         else
28        //             count++;
29        //         set.add(s.charAt(j)); 
30        //     }
31        //     maxL= Math.max(maxL, count);
32        // }
33
34        return maxL;
35    }
36}
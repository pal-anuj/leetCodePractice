// Last updated: 12/10/2026, 22:56:28
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int n = s.length();
4        int max = 0;
5        Map<Character, Integer> freqIdx = new HashMap<>();
6        int l = 0;
7        // a b c d b c b b
8        for (int r = 0; r < n; r++) {
9            char c = s.charAt(r);
10            if (freqIdx.containsKey(c)) {
11                // System.out.println(max);
12                l = Math.max(l, freqIdx.get(c) + 1);
13            }
14            max = Math.max(max, r - l + 1);
15            freqIdx.put(c, r);
16        }
17        return max;
18    }
19}
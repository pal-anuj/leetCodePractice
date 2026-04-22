// Last updated: 22/04/2026, 07:13:55
1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3        int[] freq = new int[26];
4        for (char c : p.toCharArray()) {
5            freq[c - 'a']++;
6        }
7
8        List<Integer> res = new ArrayList<>();
9        int left = 0;
10        int right = 0;
11        int count = p.length();
12
13        while (right < s.length()) {
14            if (freq[s.charAt(right++) - 'a']-- > 0)
15                count--;
16
17            if (count == 0)
18                res.add(left);
19
20            if (right - left == p.length() && freq[s.charAt(left++) - 'a']++ >= 0)
21                count++;
22        }
23
24        return res;
25    }
26}
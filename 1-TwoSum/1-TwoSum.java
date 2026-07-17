// Last updated: 17/07/2026, 20:33:49
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        int[] arr = new int[26];
4        if(s.length()!= t.length())
5            return false;
6
7        for (int i = 0; i < s.length(); i++) {
8            arr[s.charAt(i) - 'a']++;
9            arr[t.charAt(i) - 'a']--;
10        }
11
12        for (int num : arr) {
13            if (num != 0)
14                return false;
15        }
16        return true;
17    }
18}
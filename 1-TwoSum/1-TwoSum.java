// Last updated: 17/07/2026, 20:38:16
1class Solution {
2    public boolean canConstruct(String ransomNote, String magazine) {
3
4        int[] arr = new int[26];
5        for (char c : magazine.toCharArray()) {
6            arr[c - 'a']++;
7        }
8
9        for (char c : ransomNote.toCharArray()) {
10            if (arr[c - 'a'] > 0) {
11                arr[c - 'a']--;
12            } else
13                return false;
14        }
15
16        return true;
17    }
18}
// Last updated: 27/05/2026, 00:26:29
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int[] arr = new int[26];
4        int count = 0;
5        System.out.println(arr[0]);
6        for (char ch = 'a'; ch <= 'z'; ch++) {
7            boolean lowerPresent = word.contains(word.valueOf(ch));
8            boolean upperPresent = word.contains(word.valueOf(Character.toUpperCase(ch)));
9
10            if (lowerPresent && upperPresent)
11                count++;
12        }
13
14        return count;
15    }
16}
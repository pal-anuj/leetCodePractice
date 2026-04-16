// Last updated: 16/04/2026, 06:01:24
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxL = 0;
4
5        // Efficient Approach
6        // int left = 0;
7        // HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
8
9        for(int i=0;i<s.length();i++){
10            int count=1;
11            Set<Character> set= new HashSet<>();
12            set.add(s.charAt(i));
13            for(int j=i+1;j<s.length();j++){
14                if(set.contains(s.charAt(j)))
15                    break;
16                else
17                    count++;
18                set.add(s.charAt(j)); 
19            }
20            maxL= Math.max(maxL, count);
21        }
22
23        return maxL;
24    }
25}
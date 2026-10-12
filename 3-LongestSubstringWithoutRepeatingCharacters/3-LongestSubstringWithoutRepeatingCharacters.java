// Last updated: 12/10/2026, 22:39:16
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int n = s.length();
4        int max=0;
5
6        for(int i=0;i<n;i++){
7            Map<Character, Integer> freqIdx= new HashMap<>();
8            int count=0;
9            for(int j=i;j<n;j++){
10                char c= s.charAt(j);
11                if(freqIdx.containsKey(c)){
12                    break;
13                }
14                count++;
15                freqIdx.put(c, i);
16            }
17            max= Math.max(max,count);
18        }
19        return max;
20    }
21}
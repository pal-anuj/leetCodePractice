// Last updated: 25/07/2026, 00:13:38
1class Solution {
2    public String frequencySort(String s) {
3
4        Map<Character, Integer> map = new HashMap<>();
5        for (char c : s.toCharArray()) {
6            map.put(c, map.getOrDefault(c, 0) + 1);
7        }
8
9        List<Map.Entry<Character,Integer>> freqMapList = new ArrayList<>(map.entrySet());
10        freqMapList.sort((a,b) -> b.getValue() - a.getValue());
11
12        StringBuilder sb = new StringBuilder();
13        for (Map.Entry<Character, Integer> e : freqMapList) {
14            char ch=  e.getKey();
15            int count= e.getValue();
16            sb.append(String.valueOf(ch).repeat(count));
17        }
18
19        return sb.toString();
20    }
21}
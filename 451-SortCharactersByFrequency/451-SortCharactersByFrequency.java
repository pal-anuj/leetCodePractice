// Last updated: 05/12/2025, 08:25:16
1class Solution {
2    public String frequencySort(String s) {
3        
4        // 1. Count frequencies
5        Map<Character, Integer> freq= new HashMap<>();
6        for(char c : s.toCharArray()){
7            freq.put(c, freq.getOrDefault(c, 0)+1);
8        }
9
10        // 2. Convert to list of map entries
11        List<Map.Entry<Character, Integer>> list= new ArrayList<>(freq.entrySet());
12        // 3. Sort by decreasing frequency
13        list.sort((a,b) -> b.getValue()- a.getValue());
14
15        // 4. Build result string
16        StringBuilder sb= new StringBuilder();
17        for(Map.Entry<Character, Integer> e : list){
18            char ch= e.getKey();
19            int count= e.getValue();
20            sb.append(String.valueOf(ch).repeat(count));
21        }
22        
23        return sb.toString();
24    }
25}
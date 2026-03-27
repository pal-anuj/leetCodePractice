// Last updated: 27/03/2026, 22:40:43
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        HashMap<String, List<String>> group = new HashMap<>();
4        // Optimized approach, Time: O(n * k), No sorting → faster
5
6        for (String str : strs) {
7            int[] count = new int[26];
8            for (char c : str.toCharArray()) {
9                count[c - 'a']++;
10            }
11
12            StringBuilder keyBuilder = new StringBuilder();
13            for (int i = 0; i < 26; i++) {
14                keyBuilder.append(count[i]).append("#");
15            }
16
17            String key = keyBuilder.toString();
18            group.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
19        }
20        // // Efficient Approach Time: O(n * k log k), Space: O(n * k)
21        // for (String str : strs) {
22        //     char[] chars = str.toCharArray();
23        //     Arrays.sort(chars); // sort characters
24        //     String key = new String(chars);
25
26        //     group.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
27        //     // if (group.containsKey(key)) {
28        //     //     List<String> l = group.get(key);
29        //     //     l.add(strs[i]);
30        //     // } else {
31        //     //     List<String> l = new ArrayList<>();
32        //     //     l.add(strs[i]);
33        //     //     group.put(key, l);
34        //     // }
35        // }
36        return new ArrayList<>(group.values());
37    }
38}
// Last updated: 27/03/2026, 22:34:43
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3
4        // Efficient Approach Time: O(n * k log k), Space: O(n * k)
5        HashMap<String, List<String>> group = new HashMap<>();
6        for (String str : strs) {
7            char[] chars = str.toCharArray();
8            Arrays.sort(chars); // sort characters
9            String key = new String(chars);
10
11            group.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
12            // if (group.containsKey(key)) {
13            //     List<String> l = group.get(key);
14            //     l.add(strs[i]);
15            // } else {
16            //     List<String> l = new ArrayList<>();
17            //     l.add(strs[i]);
18            //     group.put(key, l);
19            // }
20        }
21        return new ArrayList<>(group.values());
22    }
23}
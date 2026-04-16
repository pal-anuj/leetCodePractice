// Last updated: 16/04/2026, 05:46:51
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        Map<String, List<String>> group = new HashMap<>();
4        for (String str : strs) {
5            char[] charArr = str.toCharArray();
6            Arrays.sort(charArr);
7            String key = new String(charArr);
8
9            group.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
10            // if (group.containsKey(key)) {
11            //     List<String> ls = group.get(key);
12            //     ls.add(str);
13            // } else {
14            //     List<String> ls = new ArrayList<>();
15            //     ls.add(str);
16            //     group.put(key, ls);
17            // }
18        }
19
20        return new ArrayList<>(group.values());
21    }
22}
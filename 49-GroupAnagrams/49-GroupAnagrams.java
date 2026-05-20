// Last updated: 20/05/2026, 12:29:36
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        Map<String, List<String>> group = new HashMap<>();
4        for (String str : strs) {
5            char[] arr = str.toCharArray();
6            Arrays.sort(arr);
7
8            String key = String.valueOf(arr);
9            group.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
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
20        List<List<String>> res = new ArrayList<>();
21        group.forEach((key, value) -> res.add(value));
22        return res;
23    }
24}
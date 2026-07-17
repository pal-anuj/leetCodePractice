// Last updated: 17/07/2026, 20:55:01
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3
4        Map<String, List<String>> map = new HashMap<>();
5        for (String str : strs) {
6            char[] arr = str.toCharArray();
7            Arrays.sort(arr);
8            String key = new String(arr);
9
10            if (map.containsKey(key)) {
11                map.get(key).add(str);
12            } else {
13                map.put(key, new ArrayList<>(Arrays.asList(str)));
14            }
15        }
16        return new ArrayList<>(map.values());
17    }
18}
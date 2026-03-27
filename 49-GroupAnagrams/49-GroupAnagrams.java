// Last updated: 27/03/2026, 22:27:31
1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        
4        // Efficient Approach Time Complexity: O(n*klogk), Space complexity: O(n+k)
5        HashMap<String, List<String>> group = new HashMap<>();
6        for (int i = 0; i < strs.length; i++) {
7            char[] ch = strs[i].toCharArray();
8            Arrays.sort(ch);
9
10            String key = new String(ch);
11
12            if (group.containsKey(key)) {
13                List<String> l = group.get(key);
14                l.add(strs[i]);
15            } else {
16                List<String> l = new ArrayList<>();
17                l.add(strs[i]);
18                group.put(key, l);
19            }
20        }
21        return new ArrayList<>(group.values());
22    }
23}
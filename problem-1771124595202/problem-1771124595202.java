// Last updated: 15/02/2026, 08:33:15
1class Solution {
2
3    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
4        HashMap<Integer, Boolean> map = new HashMap<>();
5
6        for (int num : bulbs) {
7            if (!map.containsKey(num))
8                map.put(num, true);
9            else if (map.get(num) == true)
10                map.put(num, false);
11            else
12                map.put(num, true);
13        }
14
15        List<Integer> res = new ArrayList<>();
16        for (Map.Entry<Integer, Boolean> entry : map.entrySet())
17            if (entry.getValue())
18                res.add(entry.getKey());
19
20        Collections.sort(res);
21        return res;
22    }
23}